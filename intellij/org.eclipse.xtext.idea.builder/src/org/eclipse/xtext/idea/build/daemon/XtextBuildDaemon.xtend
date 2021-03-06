/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Provider
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.nio.channels.SelectionKey
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel
import java.nio.channels.spi.SelectorProvider
import org.apache.log4j.FileAppender
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.TTCCLayout
import org.eclipse.xtext.idea.build.daemon.Protocol.BuildRequest
import org.eclipse.xtext.idea.build.daemon.Protocol.StopServer
import org.eclipse.xtext.idea.build.net.ObjectChannel

import static org.eclipse.xtext.idea.build.daemon.XtextBuildDaemon.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextBuildDaemon {

	static val LOG = Logger.getLogger(XtextBuildDaemon)

	def static void main(String[] args) {
		try {
			LOG.parent.addAppender(new FileAppender(new TTCCLayout(), 'xtext_builder_daemon.log', true))
			LOG.level = Level.INFO
			val injector = Guice.createInjector(new BuildDaemonModule)
			injector.getInstance(Server).run(args.parse)
		} catch (Exception exc) {
			System.err.println('Error ' + exc.message)
		}
	}

	private static def parse(String... args) {
		val arguments = new Arguments
		val i = args.iterator
		while (i.hasNext) {
			val arg = i.next
			switch arg {
				case '-port':
					arguments.port = Integer.parseInt(i.next)
				default:
					throw new IllegalArgumentException("Invalid argument '" + arg + "'")
			}
		}
		if (arguments.port == 0)
			throw new IllegalArgumentException('Port number must be set')
		return arguments
	}

	static class Arguments {
		int port
	}

	static class Server {
		@Inject Provider<Worker> workerProvider

		def run(Arguments arguments) {
			var ServerSocket serverSocket = null
			try {
				LOG.info('Starting xtext build daemon at port ' + arguments.port + '...')
				val socketSelector = SelectorProvider.provider().openSelector()
				val serverChannel = ServerSocketChannel.open()
				serverChannel.configureBlocking(false)
				val socketAddress = new InetSocketAddress(InetAddress.getByName('127.0.0.1'), arguments.port)
				serverChannel.socket.bind(socketAddress)
				serverChannel.register(socketSelector, SelectionKey.OP_ACCEPT)

				var receivedRequests = false
				LOG.info('... success')
				var shutdown = false
				while (!shutdown) {
					LOG.info('Accepting connections...')
					try {
						socketSelector.select(5000)
						for (key : socketSelector.selectedKeys) {
							if (key.acceptable) {
								var SocketChannel socketChannel = null
								try {
									socketChannel = serverChannel.accept
									if (socketChannel == null) {
										if (!receivedRequests) {
											LOG.info('No requests within ' + serverSocket.soTimeout + 'ms.')
											shutdown = true
										}
									} else {
										socketChannel.configureBlocking(true)
										receivedRequests = true
										shutdown = workerProvider.get.serve(socketChannel)
									}
								} finally {
									socketChannel?.close
								}
							}
						}
					} catch (Exception exc) {
						LOG.error('Error during build', exc)
					}
				}
			} catch (Exception exc) {
				LOG.error('Error starting server socket', exc)
			}
			LOG.info('Shutting down')
			serverSocket?.close
		}
	}

	static class Worker {

		@Inject IdeaStandaloneBuilder standaloneBuilder

		@Inject XtextBuildResultCollector resultCollector

		ObjectChannel channel

		def serve(SocketChannel socketChannel) {
			channel = new ObjectChannel(socketChannel)
			val msg = channel.readObject
			switch (msg) {
				StopServer: {
					LOG.info('Received StopServer')
					return true
				}
				BuildRequest: {
					LOG.info('Received BuildRequest. Start build...')
					val buildResult = build(msg)
					LOG.info('...finished.')
					channel.writeObject(buildResult)
					LOG.info('Result sent.')
				}
			}
			return false
		}

		def build(BuildRequest request) {
			resultCollector.output = channel
			standaloneBuilder => [
				failOnValidationError = false
				languages = XtextLanguages.getLanguageAccesses
				buildData = new XtextBuildParameters(request)
				buildResultCollector = resultCollector
				launch
			]
			resultCollector.buildResult
		}
	}
}
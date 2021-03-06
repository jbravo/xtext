package org.eclipse.xtext.parser.epatch.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class EpatchTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageFileType.DEFAULT_EXTENSION);
	}

}

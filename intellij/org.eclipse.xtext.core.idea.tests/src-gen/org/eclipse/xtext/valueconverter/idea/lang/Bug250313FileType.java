package org.eclipse.xtext.valueconverter.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug250313FileType extends LanguageFileType {

	public static final Bug250313FileType INSTANCE = new Bug250313FileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug250313";

	private Bug250313FileType() {
		super(Bug250313Language.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug250313 files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug250313";
	}

}

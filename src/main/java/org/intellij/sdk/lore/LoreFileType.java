package org.intellij.sdk.lore;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class LoreFileType extends LanguageFileType {

    public static final LoreFileType INSTANCE = new LoreFileType();

    private LoreFileType() {
        super(LoreLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Lore File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Lore language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "lore";
    }

    @Override
    public Icon getIcon() {
        return LoreIcons.FILE;
    }

}

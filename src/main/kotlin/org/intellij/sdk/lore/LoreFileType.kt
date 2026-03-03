package org.intellij.sdk.lore

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object LoreFileType : LanguageFileType(LoreLanguage.INSTANCE) {
    override fun getName(): String = "Lore File"
    override fun getDescription(): String = "Lore language file"
    override fun getDefaultExtension(): String = "lore"
    override fun getIcon(): Icon = LoreIcons.FILE
}
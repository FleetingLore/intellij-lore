package org.intellij.sdk.lore

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class LoreFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, LoreLanguage.INSTANCE) {
    override fun getFileType(): FileType = LoreFileType
    override fun toString(): String = "Lore File"
}
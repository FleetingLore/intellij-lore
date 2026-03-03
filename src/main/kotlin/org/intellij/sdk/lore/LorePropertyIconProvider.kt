package org.intellij.sdk.lore

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import javax.swing.Icon

class LorePropertyIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, i: Int): Icon? {
        return when (psiElement) {
            is LoreTitleLine-> LoreIcons.TITLE
            is LoreLinkLine -> LoreIcons.LINK
            is LoreAtomLine -> LoreIcons.ATOM
            is LoreToken-> LoreIcons.EMPTY
            else -> null
        }
    }
}
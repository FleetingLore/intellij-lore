package org.intellij.sdk.lore.line

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import org.intellij.sdk.lore.LoreIcons
import org.intellij.sdk.lore.line.types.LoreLinkLine
import org.intellij.sdk.lore.LoreToken
import org.intellij.sdk.lore.line.types.LoreAtomLine
import org.intellij.sdk.lore.line.types.LoreTitleLine
import org.intellij.sdk.lore.line.types.LoreMarkdownLine
import org.intellij.sdk.lore.line.types.LoreHtmlLine
import javax.swing.Icon

class LorePropertyIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, i: Int): Icon? {
        return when (psiElement) {
            is LoreTitleLine -> LoreIcons.TITLE
            is LoreLinkLine -> LoreIcons.LINK
            is LoreMarkdownLine -> LoreIcons.LINK  // 暂时使用 LINK 图标
            is LoreHtmlLine -> LoreIcons.LINK      // 暂时使用 LINK 图标
            is LoreAtomLine -> LoreIcons.ATOM
            is LoreToken -> LoreIcons.EMPTY
            else -> null
        }
    }
}
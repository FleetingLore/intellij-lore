package org.intellij.sdk.lore

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import javax.swing.Icon

class LoreDirectoryIconProvider : IconProvider() {
    override fun getIcon(element: PsiElement, flags: Int): Icon? {
        if (element is PsiDirectory) {
            // 检查目录下是否有 local.lore
            if (element.findFile("local.lore") != null) {
                return LoreIcons.CATEGORY  // 返回 Category 专用图标
            }
        }
        return null
    }
}
package org.intellij.sdk.lore

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet

class LoreFindUsagesProvider : FindUsagesProvider {

    // 告诉 IDE 哪些 Token 是"单词"（可以被搜索）
    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(
            LoreLexer(),  // 你的 Lexer
            TokenSet.create(LoreTypes.ATOM, LoreTypes.TITLE, LoreTypes.LINK),  // 标识符
            TokenSet.EMPTY,  // 注释（忽略）
            TokenSet.EMPTY   // 字符串字面量
        )
    }

    // 哪些元素可以被搜索
    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        // 简单起见，所有行类型都可以被搜索
        return psiElement is LoreAtomLine ||
                psiElement is LoreTitleLine ||
                psiElement is LoreLinkLine
    }

    // 帮助文档 ID（用不到就返回 null）
    override fun getHelpId(psiElement: PsiElement): String? = null

    // 元素类型的文字描述（比如 "atom"、"title"）
    override fun getType(element: PsiElement): String {
        return when (element) {
            is LoreTitleLine -> "title"
            is LoreLinkLine -> "link"
            is LoreAtomLine -> "atom"
            else -> "unknown"
        }
    }

    // 元素在查找结果里显示的名称
    override fun getDescriptiveName(element: PsiElement): String {
        return when (element) {
            is LoreTitleLine -> element.text?.substringAfter("+ ") ?: ""
            is LoreLinkLine -> element.text?.substringBefore(" = ") ?: ""
            is LoreAtomLine -> element.text?.trim() ?: ""
            else -> ""
        }
    }

    // 元素在查找结果里显示的文本
    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return getDescriptiveName(element)
    }
}
package org.intellij.sdk.lore

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class LoreParserDefinition : ParserDefinition {
    // 1. 提供 Lexer
    override fun createLexer(project: Project?): Lexer = LoreLexer()

    // 2. 提供 Parser
    override fun createParser(project: Project?): PsiParser = LoreParser()
    override fun getFileNodeType(): IFileElementType {
        TODO("Not yet implemented")
    }

    override fun getCommentTokens(): TokenSet {
        TODO("Not yet implemented")
    }

    override fun getStringLiteralElements(): TokenSet {
        TODO("Not yet implemented")
    }

    override fun createElement(p0: ASTNode?): PsiElement {
        TODO("Not yet implemented")
    }

    // 3. 提供文件节点
    override fun createFile(viewProvider: FileViewProvider): PsiFile = LoreFile(viewProvider)

    // 4. 提供节点工厂
    override fun createElement(node: ASTNode): LoreToken =
        when (node.elementType) {
            LoreTypes.PLUS_LINE -> LorePlusLine(node)
            LoreTypes.LINK_LINE -> LoreLinkLine(node)
            LoreTypes.TEXT_LINE -> LoreTextLine(node)
            else -> LoreToken(node)
        } as LoreToken
}

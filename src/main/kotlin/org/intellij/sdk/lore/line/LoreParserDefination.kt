package org.intellij.sdk.lore.line

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
import org.intellij.sdk.lore.LoreFile
import org.intellij.sdk.lore.LoreLanguage
import org.intellij.sdk.lore.line.LoreLexer
import org.intellij.sdk.lore.line.types.LoreLinkLine
import org.intellij.sdk.lore.line.LoreParser
import org.intellij.sdk.lore.LoreToken
import org.intellij.sdk.lore.line.types.LoreAtomLine
import org.intellij.sdk.lore.line.types.LoreTitleLine

class LoreParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = LoreLexer()
    override fun createParser(project: Project?): PsiParser = LoreParser()

    override fun getFileNodeType(): IFileElementType {
        return IFileElementType(LoreLanguage.Companion.INSTANCE)
    }

    override fun getCommentTokens(): TokenSet = TokenSet.EMPTY
    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createFile(viewProvider: FileViewProvider): PsiFile = LoreFile(viewProvider)

    override fun createElement(node: ASTNode): PsiElement {
        return when (node.elementType) {
            LoreTypes.TITLE -> LoreTitleLine(node)
            LoreTypes.LINK -> LoreLinkLine(node)
            LoreTypes.ATOM -> LoreAtomLine(node)
            else -> LoreToken(node)
        }
    }
}
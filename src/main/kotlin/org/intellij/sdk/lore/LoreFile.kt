package org.intellij.sdk.lore

import com.intellij.lang.FileASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.NlsContexts
import com.intellij.openapi.util.NlsSafe
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileSystemItem
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiReference
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.PsiElementProcessor
import com.intellij.psi.search.SearchScope
import org.jetbrains.annotations.NonNls
import javax.swing.Icon

class LoreFile(viewProvider: FileViewProvider) : LanguageFileType(LoreLanguage.INSTANCE), PsiFile {
    override fun isDirectory(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): @NonNls String {
        TODO("Not yet implemented")
    }

    override fun getPresentation(): ItemPresentation? {
        TODO("Not yet implemented")
    }

    override fun setName(p0: @NlsSafe String): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun processChildren(p0: PsiElementProcessor<in PsiFileSystemItem>): Boolean {
        TODO("Not yet implemented")
    }

    override fun getDescription(): @NlsContexts.Label String {
        TODO("Not yet implemented")
    }

    override fun getDefaultExtension(): @NlsSafe String {
        TODO("Not yet implemented")
    }

    override fun getIcon(): Icon? {
        TODO("Not yet implemented")
    }

    override fun getIcon(p0: Int): Icon? {
        TODO("Not yet implemented")
    }

    override fun getVirtualFile(): VirtualFile? {
        TODO("Not yet implemented")
    }

    override fun getContainingDirectory(): PsiDirectory? {
        TODO("Not yet implemented")
    }

    override fun getParent(): PsiDirectory? {
        TODO("Not yet implemented")
    }

    override fun getModificationStamp(): Long {
        TODO("Not yet implemented")
    }

    override fun getOriginalFile(): PsiFile {
        TODO("Not yet implemented")
    }

    override fun getFileType(): FileType {
        TODO("Not yet implemented")
    }

    override fun getPsiRoots(): Array<out PsiFile?> {
        TODO("Not yet implemented")
    }

    override fun getViewProvider(): FileViewProvider {
        TODO("Not yet implemented")
    }

    override fun getNode(): FileASTNode? {
        TODO("Not yet implemented")
    }

    override fun subtreeChanged() {
        TODO("Not yet implemented")
    }

    override fun checkSetName(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun getProject(): Project {
        TODO("Not yet implemented")
    }

    override fun getManager(): PsiManager? {
        TODO("Not yet implemented")
    }

    override fun getChildren(): Array<out PsiElement> {
        TODO("Not yet implemented")
    }

    override fun getFirstChild(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getLastChild(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getNextSibling(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getPrevSibling(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getContainingFile(): PsiFile? {
        TODO("Not yet implemented")
    }

    override fun getTextRange(): TextRange? {
        TODO("Not yet implemented")
    }

    override fun getStartOffsetInParent(): Int {
        TODO("Not yet implemented")
    }

    override fun getTextLength(): Int {
        TODO("Not yet implemented")
    }

    override fun findElementAt(p0: Int): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun findReferenceAt(p0: Int): PsiReference? {
        TODO("Not yet implemented")
    }

    override fun getTextOffset(): Int {
        TODO("Not yet implemented")
    }

    override fun getText(): @NlsSafe String? {
        TODO("Not yet implemented")
    }

    override fun textToCharArray(): CharArray {
        TODO("Not yet implemented")
    }

    override fun getNavigationElement(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getOriginalElement(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun textMatches(p0: @NonNls CharSequence): Boolean {
        TODO("Not yet implemented")
    }

    override fun textMatches(p0: PsiElement): Boolean {
        TODO("Not yet implemented")
    }

    override fun textContains(p0: Char): Boolean {
        TODO("Not yet implemented")
    }

    override fun accept(p0: PsiElementVisitor) {
        TODO("Not yet implemented")
    }

    override fun acceptChildren(p0: PsiElementVisitor) {
        TODO("Not yet implemented")
    }

    override fun copy(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun add(p0: PsiElement): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun addBefore(
        p0: PsiElement,
        p1: PsiElement?
    ): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun addAfter(
        p0: PsiElement,
        p1: PsiElement?
    ): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun checkAdd(p0: PsiElement) {
        TODO("Not yet implemented")
    }

    override fun addRange(
        p0: PsiElement?,
        p1: PsiElement?
    ): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun addRangeBefore(
        p0: PsiElement,
        p1: PsiElement,
        p2: PsiElement?
    ): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun addRangeAfter(
        p0: PsiElement?,
        p1: PsiElement?,
        p2: PsiElement?
    ): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun delete() {
        TODO("Not yet implemented")
    }

    override fun checkDelete() {
        TODO("Not yet implemented")
    }

    override fun deleteChildRange(p0: PsiElement?, p1: PsiElement?) {
        TODO("Not yet implemented")
    }

    override fun replace(p0: PsiElement): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun isValid(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isWritable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getReference(): PsiReference? {
        TODO("Not yet implemented")
    }

    override fun getReferences(): Array<out PsiReference?> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getCopyableUserData(p0: Key<T?>): T? {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> putCopyableUserData(p0: Key<T?>, p1: T?) {
        TODO("Not yet implemented")
    }

    override fun processDeclarations(
        p0: PsiScopeProcessor,
        p1: ResolveState,
        p2: PsiElement?,
        p3: PsiElement
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun getContext(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun isPhysical(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getResolveScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getUseScope(): SearchScope {
        TODO("Not yet implemented")
    }

    override fun isEquivalentTo(p0: PsiElement?): Boolean {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getUserData(p0: Key<T?>): T? {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> putUserData(p0: Key<T?>, p1: T?) {
        TODO("Not yet implemented")
    }
}
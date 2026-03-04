package org.intellij.sdk.lore.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiManager
import org.intellij.sdk.lore.LoreIcons

class NewCategoryAction : AnAction(
    "Lore Category",
    "Create new Lore Category",
    LoreIcons.CATEGORY
) {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val parentDir = getSelectedDirectory(e) ?: return

        val categoryName = Messages.showInputDialog(
            project,
            "Enter category name:",
            "New Lore Category",
            Messages.getQuestionIcon()
        ) ?: return

        WriteAction.run<Throwable> {
            val categoryDir = parentDir.createSubdirectory(categoryName)
            categoryDir.createFile("local.lore")
        }
    }

    private fun getSelectedDirectory(e: AnActionEvent): PsiDirectory? {
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return null
        val project = e.project ?: return null
        return PsiManager.getInstance(project).findDirectory(virtualFile)
    }
}
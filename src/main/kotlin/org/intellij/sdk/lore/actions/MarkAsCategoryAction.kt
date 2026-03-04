package org.intellij.sdk.lore.actions

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiManager
import org.intellij.sdk.lore.LoreIcons

class MarkAsLoreCategoryAction : AnAction(), DumbAware {
    override fun getActionUpdateThread() = ActionUpdateThread.EDT

    override fun update(e: AnActionEvent) {
        val presentation = e.presentation
        presentation.icon = LoreIcons.CATEGORY
        presentation.text = "Mark as Lore Category"
        presentation.description = "Create local.lore in selected directory"

        val project = e.project
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)
        presentation.isEnabledAndVisible = project != null &&
                virtualFile?.isDirectory == true &&
                !isCategory(virtualFile)
    }

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val directory = getSelectedDirectory(e) ?: return

        WriteAction.run<Throwable> {
            directory.createFile("local.lore")
        }

        Messages.showInfoMessage(
            project,
            "Directory marked as Lore Category",
            "Success"
        )
    }

    private fun getSelectedDirectory(e: AnActionEvent): PsiDirectory? {
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return null
        val project = e.project ?: return null
        return PsiManager.getInstance(project).findDirectory(virtualFile)
    }

    private fun isCategory(dir: VirtualFile): Boolean {
        return dir.findChild("local.lore") != null
    }
}
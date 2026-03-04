package org.intellij.sdk.lore.actions

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import org.intellij.sdk.lore.LoreIcons

class UnmarkAsCategoryAction : AnAction(), DumbAware {

    override fun getActionUpdateThread() = ActionUpdateThread.EDT

    override fun update(e: AnActionEvent) {
        val presentation = e.presentation
        presentation.icon = LoreIcons.FILE
        presentation.text = "Unmark as Lore Category"
        presentation.description = "Removes Lore Category marker by deleting local.lore"

        val project = e.project
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)

        presentation.isEnabledAndVisible = project != null &&
                virtualFile?.isDirectory == true &&
                isCategory(virtualFile)
    }

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return

        WriteAction.run<Throwable> {
            val psiDir = PsiManager.getInstance(project).findDirectory(virtualFile)
            psiDir?.findFile("local.lore")?.delete()
        }
    }

    private fun isCategory(dir: VirtualFile): Boolean {
        return dir.findChild("local.lore") != null
    }
}
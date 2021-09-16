package taufiq.apps.todo_compose.data.model

import androidx.compose.ui.graphics.Color
import taufiq.apps.todo_compose.ui.theme.HighPriorityColor
import taufiq.apps.todo_compose.ui.theme.LowPriorityColor
import taufiq.apps.todo_compose.ui.theme.MediumPriorityColor
import taufiq.apps.todo_compose.ui.theme.NonePriorityColor


/**
 * Created By Taufiq on 9/16/2021.
 *
 */
enum class Priority(val color : Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    None(NonePriorityColor)
}
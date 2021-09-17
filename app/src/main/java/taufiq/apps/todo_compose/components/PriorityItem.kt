package taufiq.apps.todo_compose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import taufiq.apps.todo_compose.data.model.Priority
import taufiq.apps.todo_compose.ui.theme.LARGE_PADDING
import taufiq.apps.todo_compose.ui.theme.PRIORITY_INDICATOR_SIZE
import taufiq.apps.todo_compose.ui.theme.Typography

/**
 * Created By Taufiq on 9/17/2021.
 *
 */

@Composable
fun PriorityItem(priority: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE), onDraw = {
            drawCircle(color = priority.color)
        })

        Text(
            modifier = Modifier.padding(start = LARGE_PADDING),
            text = priority.name,
            style = Typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Preview
@Composable
fun PriorityItemPreview() {
    PriorityItem(priority = Priority.HIGH)
}
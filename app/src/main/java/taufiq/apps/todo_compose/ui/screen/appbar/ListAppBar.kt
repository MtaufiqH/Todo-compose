package taufiq.apps.todo_compose.ui.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import taufiq.apps.todo_compose.R
import taufiq.apps.todo_compose.data.model.Priority
import taufiq.apps.todo_compose.ui.screen.appbar.ListAppBarAction
import taufiq.apps.todo_compose.ui.screen.appbar.SortAction
import taufiq.apps.todo_compose.ui.theme.topAppBarBackgroundColor
import taufiq.apps.todo_compose.ui.theme.topAppBarContentColor

/**
 * Created By Taufiq on 9/17/2021.
 *
 */

@Composable
fun ListAppBar() {
    DefaultListAppBar(onSearchClicked = {}, onSortClicked = {})
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.appbar_list_screen_title),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            ListAppBarAction(onSearchClicked = onSearchClicked)
            SortAction(onSortClicked = onSortClicked)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}

@Preview
@Composable
fun AppBarPreview() {
    DefaultListAppBar(onSearchClicked = {}, onSortClicked = {})
}
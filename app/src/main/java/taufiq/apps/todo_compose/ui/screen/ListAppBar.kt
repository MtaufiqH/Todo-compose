package taufiq.apps.todo_compose.ui.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import taufiq.apps.todo_compose.R
import taufiq.apps.todo_compose.ui.theme.topAppBarBackgroundColor
import taufiq.apps.todo_compose.ui.theme.topAppBarContentColor

/**
 * Created By Taufiq on 9/17/2021.
 *
 */

@Composable
fun ListAppBar() {
    DefaultListAppBar()
}

@Composable
fun DefaultListAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.appbar_list_screen_title),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}
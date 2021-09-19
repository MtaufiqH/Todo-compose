package taufiq.apps.todo_compose.ui.screen

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import taufiq.apps.todo_compose.R
import taufiq.apps.todo_compose.ui.screen.appbar.ListAppBar
import taufiq.apps.todo_compose.ui.theme.fabBackGroundColor
import taufiq.apps.todo_compose.ui.viewmodels.TodoViewModel
import taufiq.apps.todo_compose.utils.state.SearchAppBarState

/**
 * Created By Taufiq on 9/17/2021.
 *
 */

@Composable
fun ListScreen(navigateToTaskScreen: (taskId: Int) -> Unit, viewModel: TodoViewModel) {

    val searchAppBarState: SearchAppBarState by viewModel.searchAppBarState
    val searchTextState: String by viewModel.searchTextState

    Scaffold(
        topBar = { ListAppBar(viewModel = viewModel, searchAppBarState, searchTextState) },
        content = {},
        floatingActionButton = { ListFab(navigateToTaskScreen) },

        )

}

@Composable
fun ListFab(toTaskNavigator: (taskId: Int) -> Unit) {
    FloatingActionButton(
        onClick = {
            toTaskNavigator(-1)
        }, backgroundColor = MaterialTheme.colors.fabBackGroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_button),
            tint = Color.White,
        )
    }
}


package taufiq.apps.todo_compose.ui.screen

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import taufiq.apps.todo_compose.R

/**
 * Created By Taufiq on 9/17/2021.
 *
 */

@Composable
fun ListScreen(navigateToTaskScreen: (Int) -> Unit) {

    Scaffold(
        topBar = { ListAppBar() },
        content = {},
        floatingActionButton = { ListFab(navigateToTaskScreen) },

        )

}

@Composable
fun ListFab(toTaskNavigator: (Int) -> Unit) {
    FloatingActionButton(onClick = {
        toTaskNavigator(-1)
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_button),
            tint = Color.White
        )
    }
}


@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}

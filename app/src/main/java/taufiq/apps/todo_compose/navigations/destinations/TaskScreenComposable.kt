package taufiq.apps.todo_compose.navigations.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import taufiq.apps.todo_compose.utils.Action
import taufiq.apps.todo_compose.utils.Constants

/**
 * Created By Taufiq on 9/16/2021.
 *
 */

fun NavGraphBuilder.taskScreen(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(Constants.TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}
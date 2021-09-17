package taufiq.apps.todo_compose.navigations

import androidx.navigation.NavHostController
import taufiq.apps.todo_compose.utils.Action
import taufiq.apps.todo_compose.utils.Constants.LIST_SCREEN

/**
 * Created By Taufiq on 9/16/2021.
 *
 */
class Screen(navController: NavHostController) {

    val list: (Action) -> Unit = {
        navController.navigate(route = "list/${it.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")

    }
}
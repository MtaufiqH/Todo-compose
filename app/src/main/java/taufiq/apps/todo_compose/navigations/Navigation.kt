package taufiq.apps.todo_compose.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import taufiq.apps.todo_compose.navigations.destinations.listScreen
import taufiq.apps.todo_compose.navigations.destinations.taskScreen
import taufiq.apps.todo_compose.utils.Constants.LIST_SCREEN

/**
 * Created By Taufiq on 9/16/2021.
 *
 */

@Composable
fun SetupNavigation(navHostController: NavHostController) {

    val screen = remember(navHostController) {
        Screen(navHostController)
    }

    NavHost(navController = navHostController,startDestination = LIST_SCREEN) {

        listScreen (navigateToTaskScreen = screen.task)

        taskScreen(navigateToListScreen = screen.list)

    }

}
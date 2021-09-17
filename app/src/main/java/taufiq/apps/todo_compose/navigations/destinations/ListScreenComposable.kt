package taufiq.apps.todo_compose.navigations.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import taufiq.apps.todo_compose.utils.Constants.LIST_ARGUMENT_KEY
import taufiq.apps.todo_compose.utils.Constants.LIST_SCREEN



/**
 * Created By Taufiq on 9/16/2021.
 *
 */

fun NavGraphBuilder.listScreen(
    navigateToTaskScreen: (Int) -> Unit
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){

    }
}
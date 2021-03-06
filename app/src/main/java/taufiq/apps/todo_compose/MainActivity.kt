package taufiq.apps.todo_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.todo_compose.navigations.SetupNavigation
import taufiq.apps.todo_compose.ui.theme.TodocomposeTheme
import taufiq.apps.todo_compose.ui.viewmodels.TodoViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val viewModel by viewModels<TodoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodocomposeTheme {

                navController = rememberNavController()
                SetupNavigation(navHostController = navController,
                viewModel = viewModel)

            }
        }
    }
}
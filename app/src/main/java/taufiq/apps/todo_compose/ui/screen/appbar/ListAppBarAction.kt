package taufiq.apps.todo_compose.ui.screen.appbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import taufiq.apps.todo_compose.R
import taufiq.apps.todo_compose.components.PriorityItem
import taufiq.apps.todo_compose.data.model.Priority
import taufiq.apps.todo_compose.ui.theme.MEDIUM_PADDING
import taufiq.apps.todo_compose.ui.theme.Typography
import taufiq.apps.todo_compose.ui.theme.topAppBarContentColor

/**
 * Created By Taufiq on 9/17/2021.
 *
 */

@Composable
fun ListAppBarAction(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit) {

    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(onSortClicked: (Priority) -> Unit) {

    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(R.string.sort_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = {
                expanded = false
            }) {
                PriorityItem(priority = Priority.LOW)
                onSortClicked(Priority.LOW)
            }

            DropdownMenuItem(onClick = {
                expanded = false
            }) {
                PriorityItem(priority = Priority.HIGH)
                onSortClicked(Priority.HIGH)
            }

            DropdownMenuItem(onClick = {
                expanded = false
            }) {
                PriorityItem(priority = Priority.None)
                onSortClicked(Priority.None)
            }
        }
    }
}

@Composable
fun DeleteAllAction(onDeleteClicked: () -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = {
        expanded = true
    }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = stringResource(
                R.string.delete_all_action
            ), tint = MaterialTheme.colors.topAppBarContentColor
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = {
                expanded = true
                onDeleteClicked()
            }) {
                Text(
                    modifier = Modifier.padding(MEDIUM_PADDING),
                    text = "Delete All",
                    style = Typography.subtitle2
                )
            }
        }
    }


}




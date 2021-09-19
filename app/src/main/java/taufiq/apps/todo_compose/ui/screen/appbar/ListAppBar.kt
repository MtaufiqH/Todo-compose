package taufiq.apps.todo_compose.ui.screen.appbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import taufiq.apps.todo_compose.R
import taufiq.apps.todo_compose.data.model.Priority
import taufiq.apps.todo_compose.ui.theme.topAppBarBackgroundColor
import taufiq.apps.todo_compose.ui.theme.topAppBarContentColor
import taufiq.apps.todo_compose.ui.viewmodels.TodoViewModel
import taufiq.apps.todo_compose.utils.state.SearchAppBarState
import taufiq.apps.todo_compose.utils.state.TrailingIconState

/**
 * Created By Taufiq on 9/17/2021.
 *
 */

@Composable
fun ListAppBar(
    viewModel: TodoViewModel,
    searchState: SearchAppBarState,
    searchTextState: String
) {

    when (searchState) {
        SearchAppBarState.CLOSED -> {
            DefaultListAppBar(
                onSearchClicked = {
                    viewModel.searchAppBarState.value =
                        SearchAppBarState.OPENED
                },
                onSortClicked = {},
                onDeleteClick = {}
            )
        }
        else -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = { viewModel.searchTextState.value = it },
                onCloseClicked = {
                    viewModel.searchAppBarState.value =
                        SearchAppBarState.CLOSED
                    viewModel.searchTextState.value = ""
                },
                onSearchClicked = {}
            )

        }
    }


}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.appbar_list_screen_title),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            ListAppBarAction(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClick
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {

    var closeState : TrailingIconState = TrailingIconState.READY_TO_DELETE

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBackgroundColor
    ) {

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    text = "Search",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppBarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),

            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },

            trailingIcon = {
                IconButton(onClick = {
                    when(closeState) {
                        TrailingIconState.READY_TO_DELETE -> {
                            onTextChange("")
                            closeState = TrailingIconState.READY_TO_CLOSE
                        }

                        TrailingIconState.READY_TO_CLOSE -> {
                            if (text.isNotEmpty()) {
                                onTextChange("")
                            } else {
                                onCloseClicked()
                                TrailingIconState.READY_TO_DELETE
                            }
                        }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close icon",
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },

            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { onSearchClicked(text) }
            ),

            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colors.topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            )

        )

    }
}

@Preview
@Composable
fun AppBarPreview() {
    DefaultListAppBar(onSearchClicked = {}, onSortClicked = {}, onDeleteClick = {})
}

@Preview
@Composable
fun SearchAppBarPreview() {
    SearchAppBar(
        text = "",
        onTextChange = {},
        onCloseClicked = { },
        onSearchClicked = {}
    )
}
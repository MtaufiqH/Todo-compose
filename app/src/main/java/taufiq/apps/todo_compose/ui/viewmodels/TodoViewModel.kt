package taufiq.apps.todo_compose.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import taufiq.apps.todo_compose.data.model.TodoTask
import taufiq.apps.todo_compose.data.repositories.TodoRepository
import taufiq.apps.todo_compose.utils.state.SearchAppBarState
import javax.inject.Inject

/**
 * Created By Taufiq on 9/16/2021.
 *
 */

@HiltViewModel
class TodoViewModel @Inject constructor(private val todoRepository: TodoRepository) : ViewModel() {

    private val _allTask = MutableStateFlow<List<TodoTask>>(emptyList())
    val allTask: StateFlow<List<TodoTask>> = _allTask

    val searchAppBarState : MutableState<SearchAppBarState> = mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    fun getAllTask() {
        viewModelScope.launch {
            todoRepository.allTasks.collect { tasks ->
                _allTask.value = tasks
            }
        }
    }

}
package taufiq.apps.todo_compose.data.repositories

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import taufiq.apps.todo_compose.data.TodoDao
import taufiq.apps.todo_compose.data.model.TodoTask
import javax.inject.Inject

/**
 * Created By Taufiq on 9/16/2021.
 *
 */
@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    val allTasks = todoDao.getAllTask()
    val sortByLowPriority = todoDao.sortByLowPriority()
    val sortByHighPriority = todoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<TodoTask> =
        todoDao.getSelectedTask(taskId = taskId)

    suspend fun addTask(todoTask: TodoTask) {
        todoDao.addTask(todoTask)
    }

    suspend fun updateTask(todoTask: TodoTask) {
        todoDao.updateTask(todoTask)
    }

    suspend fun deleteTask(todoTask: TodoTask) {
        todoDao.deleteTask(task = todoTask)
    }

    suspend fun deleteAllTask(todoTask: TodoTask) {
        todoDao.deleteAllTask()
    }

    fun searchTask(query: String) {
        todoDao.searchTasks(query)
    }

}
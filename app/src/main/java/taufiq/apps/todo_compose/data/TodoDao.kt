package taufiq.apps.todo_compose.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import taufiq.apps.todo_compose.data.model.TodoTask

/**
 * Created By Taufiq on 9/16/2021.
 *
 */
@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTask(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table WHERE id= :taskId")
    fun getSelectedTask(taskId: Int): Flow<TodoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task : TodoTask)

    @Update
    suspend fun updateTask(task: TodoTask)

    @Delete // delete selected task in the table
    suspend fun deleteTask(task: TodoTask)

    @Query("DELETE FROM TODO_TABLE")
    suspend fun deleteAllTask()

    @Query("SELECT * FROM todo_table WHERE title LIKE :query OR description LIKE :query")
    fun searchTasks(query: String): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1  WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1  WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<TodoTask>>







}
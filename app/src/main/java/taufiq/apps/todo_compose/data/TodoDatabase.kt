package taufiq.apps.todo_compose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import taufiq.apps.todo_compose.data.model.TodoTask

/**
 * Created By Taufiq on 9/16/2021.
 *
 */
@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}
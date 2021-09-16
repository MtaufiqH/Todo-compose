package taufiq.apps.todo_compose.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import taufiq.apps.todo_compose.utils.Constants.DATABASE_TABLE
import taufiq.apps.todo_compose.utils.Constants.TABLE_DESCRIPTION
import taufiq.apps.todo_compose.utils.Constants.TABLE_ID
import taufiq.apps.todo_compose.utils.Constants.TABLE_PRIORITY
import taufiq.apps.todo_compose.utils.Constants.TABLE_TITLE

/**
 * Created By Taufiq on 9/16/2021.
 *
 */
@Entity(tableName = DATABASE_TABLE)
data class TodoTask(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TABLE_ID)
    val id: Int = 0,
    @ColumnInfo(name = TABLE_TITLE)
    val title: String,
    @ColumnInfo(name = TABLE_DESCRIPTION)
    val description: String,
    @ColumnInfo(name = TABLE_PRIORITY)
    val priority: Priority


)

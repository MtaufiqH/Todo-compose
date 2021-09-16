package taufiq.apps.todo_compose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import taufiq.apps.todo_compose.data.TodoDatabase
import taufiq.apps.todo_compose.utils.Constants.DATABASE_NAME
import javax.inject.Singleton

/**
 * Created By Taufiq on 9/16/2021.
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            TodoDatabase::class.java, DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideTaskDao(database: TodoDatabase) = database.todoDao()


}
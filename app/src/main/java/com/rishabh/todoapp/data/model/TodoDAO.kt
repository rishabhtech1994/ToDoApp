package com.rishabh.todoapp.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDAO {

    // All the Queries
    @Query("SELECT * FROM `todo-table` ORDER BY id ASC")
    fun getAllTask() : Flow<List<TodoTask>>

    @Query("SELECT * FROM `todo-table` WHERE id=:todoId")
    fun getSelectedTask(todoId: Int):List<TodoTask>

    // Used suspended as there is no return type as Flow
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(todoTask: TodoTask)

    @Delete
    suspend fun deleteTask(todoTask: TodoTask)

    @Query("DELETE FROM `todo-table`")
    suspend fun deleteAllTask()

    @Query("SELECT * FROM `todo-table` WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDataBase(searchQuery: String) : Flow<List<TodoTask>>

    @Query("SELECT * FROM `todo-table` ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<TodoTask>>

    @Query("SELECT * FROM `todo-table` ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2  WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<TodoTask>>
}


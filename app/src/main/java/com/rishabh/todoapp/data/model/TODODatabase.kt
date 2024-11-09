package com.rishabh.todoapp.data.model

import androidx.room.Database
import androidx.room.RoomDatabase

// This is the Database connection file
// It consists of the Data connections
@Database(entities = [TodoTasks::class], version = 1, exportSchema = false)
abstract class TODODatabase: RoomDatabase() {
    abstract fun toDodo() : TodoDAO
}
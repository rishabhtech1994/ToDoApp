package com.rishabh.todoapp.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rishabh.todoapp.utils.TODO_TABLE

// Entity to Describe the Todo table fields

@Entity(tableName = TODO_TABLE)
data class TodoTask(
    @PrimaryKey(autoGenerate = true )
    val id:Int = 0,
    val title : String,
    val description: String,
    val priority: Priority
)

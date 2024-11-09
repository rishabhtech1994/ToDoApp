package com.rishabh.todoapp.data.repository

import com.rishabh.todoapp.data.model.TodoDAO
import com.rishabh.todoapp.data.model.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * This repository will be injected to the VIewModels
 * This will communicate with the DAO
 *
 * ViewMode -->Repository --> Source (DATABASE/DAO/Network)
 *
 */
// View Model Scope will make the scope of the Repository till ViewModel
@ViewModelScoped
class ToDoRepository @Inject constructor(private val todoDAO: TodoDAO) {
    //Get All the DAO functions connection in this repo
   // We do not use suspend when the return type is Flow . as Flow already work asynchronously
    val getAllTask: Flow<List<TodoTask>> = todoDAO.getAllTask()
    val sortByLowPriority : Flow<List<TodoTask>> = todoDAO.sortByLowPriority()
    val sortByHighPriority: Flow<List<TodoTask>> = todoDAO.sortByHighPriority()

    fun getSelectedTask(taskId:Int): List<TodoTask> {
        return todoDAO.getSelectedTask(taskId)
    }
    suspend fun addTask(todoTask: TodoTask){
        return todoDAO.addTask(todoTask)
    }

    suspend fun deleteTask(todoTask: TodoTask){
        return todoDAO.deleteTask(todoTask)
    }

    suspend fun deleteAllTask(){
        return todoDAO.deleteAllTask()
    }

    fun searchDataBase(searchQuery:String): Flow<List<TodoTask>>{
        return todoDAO.searchDataBase(searchQuery)
    }

}
package com.rishabh.todoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishabh.todoapp.data.model.TodoTask
import com.rishabh.todoapp.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Injected Shared VM to the repository and added the TODO repo inside it

@HiltViewModel
class SharedViewModel @Inject constructor(private val toDoRepository: ToDoRepository) :ViewModel()  {
    // Get the Flow Data
    // Use MutableStateFlow as this the data is Mutable
    private val _allTask = MutableStateFlow<List<TodoTask>>(emptyList())
    // Expose to the View and assign the Mutable Data
    // Publically exposed
    val allTask :StateFlow<List<TodoTask>> = _allTask

    // All repo and get all the Tasks
    // Fetch all task from DB
    fun getAllTask(){
        // Coroutine Scope
        viewModelScope.launch {
            toDoRepository.getAllTask.collect {
                _allTask.value = it
            }
        }
    }



}
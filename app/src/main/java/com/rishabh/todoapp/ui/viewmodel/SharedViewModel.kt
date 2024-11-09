package com.rishabh.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishabh.todoapp.data.model.TodoDAO
import com.rishabh.todoapp.data.model.TodoTask
import com.rishabh.todoapp.data.repository.ToDoRepository
import dagger.hilt.android.scopes.ViewScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class SharedViewModel @Inject constructor(private val toDoRepository: ToDoRepository) :ViewModel()  {
    // Get the Flow Data
    // Use MutableStateFlow as this the data is Mutable
    private val _allTask = MutableStateFlow<List<TodoTask>>(emptyList())
    // Expose to the View and assign the Mutable Data
    val allTask :StateFlow<List<TodoTask>> = _allTask

    fun getAllTask(){
        // Coroutine Scope
        viewModelScope.launch {
            toDoRepository.getAllTask.collect {
                _allTask.value = it
            }
        }
    }

}
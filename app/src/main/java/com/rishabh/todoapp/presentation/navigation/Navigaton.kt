package com.rishabh.todoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rishabh.todoapp.presentation.navigation.destination.listComposable
import com.rishabh.todoapp.presentation.navigation.destination.taskComposable
import com.rishabh.todoapp.utils.LIST_SCREEN

@Composable
fun SetUpNavigation(
    navHostController: NavHostController
) {
    val screen = remember(navHostController) {
        Screens(navHostController)
    }
    NavHost(navHostController, LIST_SCREEN) {
        listComposable(screen.task)
        taskComposable(screen.list)
    }

}
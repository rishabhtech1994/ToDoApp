package com.rishabh.todoapp.presentation.navigation.destination

import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rishabh.todoapp.utils.Action
import com.rishabh.todoapp.utils.TASK_ARGUMENT_KEY
import com.rishabh.todoapp.utils.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen:(Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments =  listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){

    }

}
package com.rishabh.todoapp.presentation.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rishabh.todoapp.presentation.screen.list.ListScreen
import com.rishabh.todoapp.utils.LIST_ARGUMENT_KEY
import com.rishabh.todoapp.utils.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen:(Int) -> Unit
){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){
        ListScreen(navigateToTaskScreen = navigateToTaskScreen)
    }

}
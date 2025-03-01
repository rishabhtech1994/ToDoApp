package com.rishabh.todoapp.presentation.navigation

import androidx.navigation.NavHostController
import com.rishabh.todoapp.utils.Action
import com.rishabh.todoapp.utils.LIST_SCREEN

class Screens(navController: NavHostController) {
    // Creating the variables as per the no of screens
    // This list will take Action ENUM as Arg
    // List needs an Action from the Task Screen. So we PAss the ENUM as Id to the navigate()
    // So to Navigate from Task to List Screen , an action is passed to LIst Screen
    // remove the backstack
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}"){
            // NAV Option Builder
            // This will help to do the navigation though the Argument as the String
            // popUpTO take the LIST_SCREEN as the route arg to do teh nav
            // Inclusive = true will remove the TASK screen from BackStack
            popUpTo(LIST_SCREEN) { inclusive = true}
        }
    }

    // List SCreen should be alive when the the taskscreen is popup
    val task: (Int) -> Unit = {taskId->
        navController.navigate("task/${taskId}")
    }
}
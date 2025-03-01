package com.rishabh.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rishabh.todoapp.presentation.navigation.Screens
import com.rishabh.todoapp.presentation.theme.ToDoAppTheme
import dagger.hilt.android.AndroidEntryPoint
//Add Android Entry Point for the Hilt to Define the Entry Point

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                navController = rememberNavController()
                Screens(navController)
            }
        }
    }
}

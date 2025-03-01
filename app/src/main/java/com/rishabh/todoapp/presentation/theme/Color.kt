package com.rishabh.todoapp.presentation.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LightGrey = Color(0xFFFCFCFC)
val MediumGrey = Color(0xFF9C9C9C)
val DarkGrey = Color(0xFF141414)



val HighPriority= Color(0xFFFD0000)
val LowPriority = Color(0xFF2CFF00)
val MediumPriority = Color(0xFFFFEB3B)
val None = Color(0xFFFFFFFF)

// Creating Extension Function for Theme Check
val ColorScheme.topAppBarTextColor : Color
@Composable
get() = if(isSystemInDarkTheme()) LightGrey else Color.White

val ColorScheme.topAppBarBackgroundContainer : Color
    @Composable
    get() = if(isSystemInDarkTheme()) LightGrey else Purple40


val ColorScheme.fabBackgroundColor : Color
    @Composable
    get() = if(isSystemInDarkTheme()) LightGrey else Purple40
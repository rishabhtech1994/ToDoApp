package com.rishabh.todoapp.data.model

import androidx.compose.ui.graphics.Color
import com.rishabh.todoapp.presentation.theme.HighPriority
import com.rishabh.todoapp.presentation.theme.LowPriority
import com.rishabh.todoapp.presentation.theme.MediumPriority
import com.rishabh.todoapp.presentation.theme.None

enum class Priority(val color: Color) {
    HIGH(HighPriority),
    LOW(LowPriority),
    MEDIUM(MediumPriority),
    NONE(None)
}
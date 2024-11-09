package com.rishabh.todoapp.data.model

import androidx.compose.ui.graphics.Color
import com.rishabh.todoapp.ui.theme.HighPriority
import com.rishabh.todoapp.ui.theme.LowPriority
import com.rishabh.todoapp.ui.theme.MediumPriority
import com.rishabh.todoapp.ui.theme.None

enum class Priority(color: Color) {
    HIGH(HighPriority),
    LOW(LowPriority),
    MEDIUM(MediumPriority),
    NONE(None)
}
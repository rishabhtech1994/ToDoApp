package com.rishabh.todoapp.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rishabh.todoapp.data.model.Priority
import com.rishabh.todoapp.presentation.theme.LARGE_PADDING
import com.rishabh.todoapp.presentation.theme.PRIORITY_INDICATOR_SIZE

@Composable
fun PriorityItems(priority: Priority){
    Row(verticalAlignment =  Alignment.CenterVertically) {
        // Create the Priority with teh Text
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)){
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier.padding(LARGE_PADDING),
            text = priority.name,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun PriorityItemsPreview(){
    PriorityItems(priority = Priority.HIGH)
}
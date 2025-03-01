package com.rishabh.todoapp.presentation.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.rishabh.todoapp.R
import com.rishabh.todoapp.data.model.Priority
import com.rishabh.todoapp.presentation.components.PriorityItems
import com.rishabh.todoapp.presentation.theme.LARGE_PADDING
import com.rishabh.todoapp.presentation.theme.topAppBarBackgroundContainer
import com.rishabh.todoapp.presentation.theme.topAppBarTextColor

@Composable
fun ListAppBar() {
    DefaultListAppBar(onSearchClicked = {}, onSortActionClicked = {}, onDeleteClicked ={})
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(onSearchClicked: () -> Unit, onSortActionClicked: (Priority) -> Unit, onDeleteClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                Modifier.background(MaterialTheme.colorScheme.topAppBarTextColor)
            )
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.topAppBarBackgroundContainer),
        actions = {
            SearchAppBarAction(onSearchClicked)
            SortAction(onSortActionClicked)
            DeleteAllAction(onDeleteClicked)
        }
    )
}

@Composable
fun SearchAppBarAction(onSearchClicked: () -> Unit) {
    IconButton(onClick = {}) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(
                R.string.search_icon
            ),
            tint = MaterialTheme.colorScheme.topAppBarTextColor
        )
    }
}

@Composable
fun SortAction(
    onSortActionClicked: (Priority) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(
        onClick = {}
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_filter_list),
            contentDescription = stringResource(R.string.icon_filter),
            tint = MaterialTheme.colorScheme.topAppBarTextColor
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                onClick = { expanded = false },
                text = { PriorityItems(Priority.LOW) }
            )
            DropdownMenuItem(
                onClick = { expanded = false },
                text = { PriorityItems(Priority.HIGH) }
            )

            DropdownMenuItem(
                onClick = { expanded = false },
                text = { PriorityItems(Priority.NONE) }
            )
        }
    }
}

@Composable
fun DeleteAllAction(onDeleteClicked:() -> Unit){
    var expanded by remember { mutableStateOf(false) }
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        DropdownMenuItem(
            onClick = { expanded = false
                      onDeleteClicked()
                      },
            text = { stringResource(R.string.delete_all) },
            modifier = Modifier.padding(start = LARGE_PADDING)
        )
    }
}

@Composable
fun DefaultAppBarPreview() {
    DefaultListAppBar(onSearchClicked = {}, onSortActionClicked = {}, onDeleteClicked ={})
}
package com.example.benestapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.benestapp.domain.TodoListRepository
import com.example.benestapp.domain.structure.Task
import com.example.benestapp.domain.structure.TaskPriority
import com.example.benestapp.ui.theme.BenestAppTheme
import kotlinx.coroutines.launch

class TodoList(val todoListRepository: TodoListRepository) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BenestAppTheme {
                // A surface container using the 'background' color from the theme
                val todoList = todoListRepository.getTodoList()
                Surface(color = MaterialTheme.colors.background) {
                    AppScaffold {
                        todoListView(todoList)
                    }
                }
            }
        }
    }
}

@Composable
fun AppScaffold(
     body: @Composable () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Llista de tasques") },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }) {
                        Icon(Icons.Default.Menu, "Menu")
                    }
                }
            )
        },
        drawerContent = {
            Text("El teu espai")
            Divider()
        },
    ) {
        Box(Modifier.padding(it)) {
            body()
        }
    }
}


@Composable
fun todoListView(todoList: List<Task>) {
    Column() {
        todoList.forEach { task ->
            taskView(task)
        }
    }
}

@Composable
fun taskView(task: Task) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = task.text)
        Text(
            text = task.priority.toString(),
            modifier = Modifier
                .background(
                    MaterialTheme.colors.secondary,
                    RoundedCornerShape(20.dp)
                )
                .padding(10.dp)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    BenestAppTheme {
        AppScaffold {
            todoListView(
                mutableListOf(
                    Task(1, "prova d'una task", TaskPriority.Low),
                    Task(2, "prova d'una task prioritaria", TaskPriority.High)
                )
            )
        }
    }
}
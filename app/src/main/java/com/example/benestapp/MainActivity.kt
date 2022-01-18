package com.example.benestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.benestapp.ui.theme.BenestAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BenestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}


@Composable
fun Greeting() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "BenestApp") },
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
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ }) {
                Icon(Icons.Default.List, "Todo List")
            }
        }
    ) {
        Box(Modifier.padding(it)) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BenestAppTheme {
        Greeting()
    }
}
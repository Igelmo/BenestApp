package com.example.benestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.benestapp.ui.theme.BenestAppTheme
import com.example.benestapp.view.AppScaffold
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BenestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AppScaffold { mainContent() }
                }
            }
        }
    }
}

@Composable
fun mainContent() {
    Column(
        modifier = Modifier
        .padding(10.dp)
        .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
        ) {
        FloatingActionButton(
            onClick = { /*TODO*/ }) {
            Icon(Icons.Default.List, "Todo List")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BenestAppTheme {
        AppScaffold { mainContent() }
    }
}
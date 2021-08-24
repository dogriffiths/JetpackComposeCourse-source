package com.example.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasks.ui.theme.TasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasksTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    var complete by remember { mutableStateOf(false)}
                    val task = Task("Buy bread", complete)
                    TaskSummary(task) {
                        complete = it
                    }
//                    Column {
//                        TaskSummary("Buy bread", true)
//                        TaskSummary("Buy milk", true)
//                        TaskSummary("Attend yoga", true)
//                    }
                }
            }
        }
    }
}

data class Task(
    var name: String,
    var complete: Boolean,
)

@Composable
fun TaskSummary(task: Task, onComplete: (Boolean) -> Unit = {}) {
    Surface(color = MaterialTheme.colors.background) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            with(task) {
                Text(name, modifier = Modifier.align(Alignment.CenterVertically))
                Checkbox(checked = complete, onCheckedChange = onComplete)
            }
        }
    }
}

@Preview
@Composable
fun PreviewTaskSummary() {
    var complete by remember { mutableStateOf(false)}
    val task = Task("Buy bread", complete)
    TaskSummary(task) {
        complete = it
    }
}
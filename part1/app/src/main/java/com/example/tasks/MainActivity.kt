package com.example.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasks.TaskSummary
import com.example.tasks.ui.theme.TasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasksTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        TaskSummary("Buy bread", true)
                        TaskSummary("Buy milk", true)
                        TaskSummary("Attend yoga", true)
                    }
                }
            }
        }
    }
}

@Composable
fun TaskSummary(name: String, complete: Boolean) {
    Surface(color = MaterialTheme.colors.background) {
        Row(
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(name, modifier = Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = complete, onCheckedChange = {})
        }
    }
}

@Preview
@Composable
fun PreviewTaskSummary() {
    TaskSummary("Buy bread", true)
}
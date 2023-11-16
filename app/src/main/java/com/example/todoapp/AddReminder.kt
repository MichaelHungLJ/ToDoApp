package com.example.todoapp

import android.graphics.Paint.Style
import android.widget.EditText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.data.Reminder
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Preview (showBackground = true)
@Composable
fun addReminderScreen (
    modifier: Modifier = Modifier,
    remView: ReminderViewModel = viewModel(),
) {
    var reminderTitle by remember { mutableStateOf("")}
    var reminderContent by remember { mutableStateOf("")}

    val reminderState = remView.remState.collectAsState();

    Column (
        modifier = Modifier
            .fillMaxSize()
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row (
            modifier = Modifier
                .height(100.dp)
                .width(250.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ){
            Text (
                modifier = Modifier,
                text = "Title",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            TextField(
                value = reminderTitle,
                onValueChange = {
                    reminderTitle = it
                },
            )


        }
        Row (
            modifier = Modifier
                .height(100.dp)
                .width(250.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Content",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                value = reminderContent,
                onValueChange = {
                    reminderContent = it
                }
            )
        }

        Button(
            onClick = {
                val newReminder = Reminder(title = reminderTitle, content = reminderContent)
                remView.addReminder(newReminder)

            }) {
            Text("Add Reminder")
        }
    }
}



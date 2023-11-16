package com.example.todoapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.data.Reminder


@Preview (showBackground = true)
@Composable
fun ToDoApp (remViewModel : ReminderViewModel = viewModel()) {

    val reminderState = remViewModel.remState.collectAsState();


    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier,
    ) {
        Text(

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 20.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            text = "Reminder List"
        )
        ReminderList(reminderSet = reminderState.value.currentToDoItem)

    }
}


@Composable
fun ReminderList(reminderSet: Set<Reminder>, modifier: Modifier = Modifier) {

    val reminderList = reminderSet.toList()

    LazyColumn(modifier = modifier) {
        items(reminderList) { item ->
            ReminderCard(
                reminder = item,
            )
        }
    }
}


@Composable
fun ReminderCard(reminder: Reminder, modifier: Modifier = Modifier) {
    val checked = remember { mutableStateOf(false) }

    Card (
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
            .padding(10.dp, 10.dp)
    ){
        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                modifier = Modifier
                    .width(250.dp)
                    .fillMaxHeight()
                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ){
                Text(
                    modifier = Modifier
                        .padding(start=5.dp, top=5.dp),
                    text = reminder.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    modifier = Modifier
                        .padding(start = 5.dp, top = 5.dp)
                        .fillMaxHeight()
                        .width(250.dp),
                    text = reminder.content,
                    fontSize = 12.sp,
                )
            }
            Checkbox(
                checked = checked.value,
                onCheckedChange = { isChecked -> checked.value = isChecked })

        }
    }
}
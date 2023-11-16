package com.example.todoapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.data.Reminder
import com.example.todoapp.ui.theme.ReminderList

@Composable
fun ToDoApp () {

    val item1 = Reminder("Hello World", "The first reminder card")
    val item2 = Reminder("Hello World", "The first reminder card")
    val item3 = Reminder("Hello World", "The first reminder card")
    val item4 = Reminder("Hello World", "The first reminder card")
    val item5 = Reminder("Hello World", "The first reminder card")
    val item6 = Reminder("Hello World", "The first reminder card")
    val item7 = Reminder("Hello World", "The first reminder card")
    val item8 = Reminder("Hello World", "The first reminder card")

    val remList : MutableList<Reminder> = mutableListOf()

    remList.add(item1)
    remList.add(item2)
    remList.add(item3)
    remList.add(item4)
    remList.add(item5)
    remList.add(item6)
    remList.add(item7)
    remList.add(item8)

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
        ReminderList(reminderList = remList)

    }
}
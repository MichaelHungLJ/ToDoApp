package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.data.Reminder
import com.example.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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

@Composable
fun ReminderList( reminderList: List<Reminder>, modifier: Modifier = Modifier) {
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoAppTheme {
        HomeScreen()
    }
}
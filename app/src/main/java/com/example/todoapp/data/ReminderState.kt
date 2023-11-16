package com.example.todoapp.data

data class ReminderState(

    val item1: Reminder = Reminder("First Item", "Lorem"),
    val item2: Reminder = Reminder("Second Item", "Ipsum?"),
    val item3: Reminder = Reminder("Third Item", "Koren"),

    val currentToDoItem : MutableSet<Reminder> = mutableSetOf<Reminder>(item1,item2,item3),
    val completedItem : MutableSet<Reminder> = mutableSetOf<Reminder>(),
)

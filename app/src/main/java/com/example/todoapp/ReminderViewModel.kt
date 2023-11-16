package com.example.todoapp

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.Reminder
import com.example.todoapp.data.ReminderState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ReminderViewModel : ViewModel() {

    // Initialize state to view model
    private val reminderState = MutableStateFlow(ReminderState());

    // Declare a variable to create a read-only state
    val remState : StateFlow<ReminderState> = reminderState.asStateFlow();

    /*
        Methods to change states
        1. Add new reminders
        3. Move reminders to completed reminders
     */

    fun addReminder (newReminder : Reminder) {
        reminderState.value.currentToDoItem.add(newReminder);
    }

    fun completeReminder ( selectedReminder : Reminder) {
        reminderState.value.currentToDoItem.remove(selectedReminder);
        reminderState.value.completedItem.add(selectedReminder);
    }



}
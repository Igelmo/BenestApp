package com.example.benestapp.domain.structure

data class Task(
    val taskID: Int,
    val text: String,
    val priority: TaskPriority = TaskPriority.Low
)

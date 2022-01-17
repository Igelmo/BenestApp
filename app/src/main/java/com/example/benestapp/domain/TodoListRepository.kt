package com.example.benestapp.domain

import com.example.benestapp.domain.structure.Task

interface TodoListRepository {
    fun getTodoList(): List<Task>
    fun setTask(newTask: Task)
    fun getTask(): Task
    fun modifyTask(taskID: Int)
    fun deleteTask(taskID: Int)
}
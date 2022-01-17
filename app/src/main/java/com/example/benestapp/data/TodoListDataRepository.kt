package com.example.benestapp.data

import androidx.compose.ui.graphics.FilterQuality.Companion.High
import com.example.benestapp.domain.TodoListRepository
import com.example.benestapp.domain.structure.Task
import com.example.benestapp.domain.structure.TaskPriority

class TodoListDataRepository: TodoListRepository {
    override fun getTodoList(): List<Task> {
        return mutableListOf(Task(1, "prova d'una task", TaskPriority.Low), Task(2, "prova d'una task prioritaria", TaskPriority.High))
    }

    override fun setTask(newTask : Task) {
        TODO("Not yet implemented")
    }

    override fun getTask(): Task {
        TODO("Not yet implemented")
    }

    override fun modifyTask(taskID: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteTask(taskID: Int) {
        TODO("Not yet implemented")
    }
}
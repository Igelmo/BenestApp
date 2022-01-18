package com.example.benestapp.di

import com.example.benestapp.data.TodoListDataRepository
import com.example.benestapp.domain.TodoListRepository
import com.example.benestapp.view.TodoList
import org.koin.dsl.module

val appModule = module {
    single<TodoListRepository> {TodoListDataRepository()}
    factory { TodoList(get()) }
}
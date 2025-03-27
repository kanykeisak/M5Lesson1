package com.example.m5lesson1.di.presentation

import com.example.m5lesson1.presenter.viewmodel.CounterViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule  = module {

    viewModel<CounterViewModel> {
        CounterViewModel(
            incrementUseCase = get(),
            decrementUseCase = get(),
            getCountUseCase = get())
    }
}
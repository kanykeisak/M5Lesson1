package com.example.m5lesson1.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.m5lesson1.domain.model.CounterEntity
import com.example.m5lesson1.domain.usecases.DecrementUseCase
import com.example.m5lesson1.domain.usecases.GetCountUseCase
import com.example.m5lesson1.domain.usecases.IncrementUseCase

class CounterViewModel(
    private val incrementUseCase: IncrementUseCase,
    private val decrementUseCase: DecrementUseCase,
    private val getCountUseCase: GetCountUseCase
): ViewModel() {

    private val _counter = MutableLiveData(getCountUseCase())
    val counter : LiveData<CounterEntity> = _counter

    fun increment() {
        incrementUseCase()
        getCounter()
    }

    fun decrement() {
        decrementUseCase()
        getCounter()
    }

    private fun getCounter() {
        _counter.value = getCountUseCase()
    }
}
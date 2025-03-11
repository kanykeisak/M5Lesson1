package com.example.m5lesson1.domain.usecases

import com.example.m5lesson1.domain.repository.CounterRepository

class DecrementUseCase(
    private val counterRepository: CounterRepository,
) {
    fun decrement() = counterRepository.decrement()
}
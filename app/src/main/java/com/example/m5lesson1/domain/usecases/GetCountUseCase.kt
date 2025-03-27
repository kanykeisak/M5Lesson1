package com.example.m5lesson1.domain.usecases

import com.example.m5lesson1.domain.repository.CounterRepository

class GetCountUseCase(
    private val counterRepository: CounterRepository,
) {
    operator fun invoke() = counterRepository.getCount()
}
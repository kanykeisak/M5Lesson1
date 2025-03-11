package com.example.m5lesson1.data.repository

import com.example.m5lesson1.data.datasource.EmulateService
import com.example.m5lesson1.domain.model.CounterEntity
import com.example.m5lesson1.domain.model.OperationType
import com.example.m5lesson1.domain.repository.CounterRepository
import javax.inject.Inject

class CounterRepositoryImpl@Inject constructor(
    private val api: EmulateService
): CounterRepository {

    override fun increment() {
        api.increment()
    }

    override fun decrement() {
        api.decrement()
    }

    override fun getCount(): CounterEntity {
        val response = api.getCount()
        return  CounterEntity(
            operationType = OperationType.fromString(response.operationType),
            count = response.count
        )
    }
}
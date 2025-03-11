package com.example.m5lesson1.data.datasource

import com.example.m5lesson1.data.model.CounterDto
import com.example.m5lesson1.domain.model.CounterEntity

class EmulateService {
    private var count = 0
    private var isIncrement = false

    fun increment() {
        count++
        isIncrement = true
    }

    fun decrement() {
        count--
        isIncrement = false
    }
     fun getCount(): CounterDto{
         return CounterDto(
             operationType = if (isIncrement) "increment" else "decrement",
             count = count
         )
     }
}
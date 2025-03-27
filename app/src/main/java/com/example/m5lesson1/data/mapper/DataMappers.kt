package com.example.m5lesson1.data.mapper

import com.example.m5lesson1.data.model.CounterDto
import com.example.m5lesson1.domain.model.CounterEntity
import com.example.m5lesson1.domain.model.OperationType

fun CounterDto.toDomain(): CounterEntity{
    return CounterEntity(
        count = this.count,
        operationType = OperationType.fromString(this.operationType)
    )
}

fun CounterEntity.toDto() : CounterDto{
    return CounterDto(
        count = this.count,
        operationType = this.operationType.value
    )
}
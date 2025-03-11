package com.example.m5lesson1.domain.repository

import com.example.m5lesson1.domain.model.CounterEntity

interface CounterRepository {
    fun increment()

    fun decrement()

    fun getCount(): CounterEntity
}
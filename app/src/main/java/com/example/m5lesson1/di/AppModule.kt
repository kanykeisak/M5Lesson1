package com.example.m5lesson1.di

import com.example.m5lesson1.data.datasource.EmulateService
import com.example.m5lesson1.data.repository.CounterRepositoryImpl
import com.example.m5lesson1.domain.repository.CounterRepository
import com.example.m5lesson1.domain.usecases.DecrementUseCase
import com.example.m5lesson1.domain.usecases.GetCountUseCase
import com.example.m5lesson1.domain.usecases.IncrementUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideEmulateService() = EmulateService()

    @Provides
    @Singleton
    fun provideCounterRepository(service: EmulateService): CounterRepository {
        return CounterRepositoryImpl(service)
    }

    @Provides
    fun provideIncrementUseCase(repo: CounterRepository) = IncrementUseCase(repo)

    @Provides
    fun provideDecrementUseCase(repo: CounterRepository) = DecrementUseCase(repo)

    @Provides
    fun provideGetCountUseCase(repo: CounterRepository) = GetCountUseCase(repo)
}
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class AppModule {
//    @Binds
//    @Singleton
//    abstract fun bindCounterRepository(
//        counterRepositoryImpl: CounterRepositoryImpl
//    ): CounterRepository
//}
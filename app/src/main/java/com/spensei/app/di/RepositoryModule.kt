package com.spensei.app.di

import com.spensei.app.data.repository.CategoryRepositoryImpl
import com.spensei.app.data.repository.ExpenseRepositoryImpl
import com.spensei.app.domain.repository.CategoryRepository
import com.spensei.app.domain.repository.ExpenseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindExpenseRepository(impl: ExpenseRepositoryImpl): ExpenseRepository

    @Binds
    @Singleton
    abstract fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository
}
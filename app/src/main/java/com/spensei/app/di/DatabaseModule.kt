package com.spensei.app.di

import android.content.Context
import com.spensei.app.data.local.AppDatabase
import com.spensei.app.data.local.dao.CategoryDao
import com.spensei.app.data.local.dao.ExpenseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.internal.Provider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object DatabaseModule {

    @Provides
    @Singleton
    fun provideApplicationScope(): CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.IO)

    @Provides
    @Singleton
    fun provideAppDatabase (
        @ApplicationContext context : Context,
        categoryDaoProvider : Provider<CategoryDao>,
        applicationScope: CoroutineScope
    ): AppDatabase = AppDatabase.create(context, categoryDaoProvider,applicationScope)

    @Provides
    fun provideExpenseDao (appDatabase : AppDatabase) : ExpenseDao = appDatabase.expenseDao()

    @Provides
    fun provideCategoryDao (appDatabase: AppDatabase) : CategoryDao = appDatabase.categoryDao()

}
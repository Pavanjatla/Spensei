package com.spensei.app.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

object DatabaseModule {
    // TODO Day 4: @Provides @Singleton fun provideAppDatabase(...)
    // TODO Day 4: @Provides fun provideExpenseDao(db: AppDatabase)
}
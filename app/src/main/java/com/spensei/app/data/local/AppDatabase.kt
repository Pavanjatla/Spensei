package com.spensei.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.spensei.app.data.local.dao.CategoryDao
import com.spensei.app.data.local.dao.ExpenseDao
import com.spensei.app.data.local.entity.CategoryEntity
import com.spensei.app.data.local.entity.ExpenseEntity
import dagger.internal.Provider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [ExpenseEntity::class , CategoryEntity ::class],
    version = 1,
    exportSchema = true
)

@TypeConverters(Converters::class)

abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao() : CategoryDao
    abstract fun expenseDao() : ExpenseDao

    companion object {
        fun create(
            context: Context,
            categoryDaoProvider: Provider<CategoryDao>,
            applicationScope: CoroutineScope
        ): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "spensei.db")
                .addCallback(object : Callback() {
                    override fun onCreate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // Runs exactly once, the very first time the DB file is created on a fresh install
                        applicationScope.launch {
                            categoryDaoProvider.get().insertAll(DefaultCategories.seed)
                        }
                    }
                })
                .build()
        }
    }

}
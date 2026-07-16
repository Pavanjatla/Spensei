package com.spensei.app.domain.repository

import com.spensei.app.domain.model.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    fun getAllExpenses() : Flow<List<Expense>>
    fun getExpensesBetween(startMillis: Long, endMillis: Long): Flow<List<Expense>>
    suspend fun getExpenseById(id: Long): Expense?
    suspend fun addExpense(expense: Expense): Long
    suspend fun updateExpense(expense: Expense)
    suspend fun deleteExpense(expense: Expense)
}
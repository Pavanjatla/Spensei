package com.spensei.app.data.repository

import com.spensei.app.data.local.dao.CategoryDao
import com.spensei.app.data.local.dao.ExpenseDao
import com.spensei.app.data.mapper.toDomain
import com.spensei.app.data.mapper.toEntity
import com.spensei.app.domain.model.Expense
import com.spensei.app.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao,
    private val expenseDao : ExpenseDao
) : ExpenseRepository{

    override fun getAllExpenses(): Flow<List<Expense>> =
        combine(
            expenseDao.getAllExpenses(),
            categoryDao.getAllCategories()
        ) { expenseEntities, categoryEntities ->
            val categoryById = categoryEntities.associateBy { it.id }
            expenseEntities.mapNotNull { expenseEntity ->
                categoryById[expenseEntity.categoryId]?.let { categoryEntity ->
                    expenseEntity.toDomain(categoryEntity.toDomain())
                }
            }
        }

    override fun getExpensesBetween(startMillis: Long, endMillis: Long): Flow<List<Expense>> =
        combine(
            expenseDao.getExpensesBetween(startMillis, endMillis),
            categoryDao.getAllCategories()
        ) { expenseEntities, categoryEntities ->
            val categoryById = categoryEntities.associateBy { it.id }
            expenseEntities.mapNotNull { expenseEntity ->
                categoryById[expenseEntity.categoryId]?.let { categoryEntity ->
                    expenseEntity.toDomain(categoryEntity.toDomain())
                }
            }
        }

    override suspend fun getExpenseById(id: Long): Expense? {
        val expenseEntity = expenseDao.getExpenseById(id) ?: return null
        val categoryEntity = categoryDao.getCategoryById(expenseEntity.categoryId) ?: return null
        return expenseEntity.toDomain(categoryEntity.toDomain())
    }

    override suspend fun addExpense(expense: Expense): Long =
        expenseDao.insertExpense(expense.toEntity())

    override suspend fun updateExpense(expense: Expense) =
        expenseDao.updateExpense(expense.toEntity())

    override suspend fun deleteExpense(expense: Expense) =
        expenseDao.deleteExpense(expense.toEntity())

}
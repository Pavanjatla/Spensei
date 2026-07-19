package com.spensei.app.data.mapper

import com.spensei.app.data.local.entity.ExpenseEntity
import com.spensei.app.domain.model.Category
import com.spensei.app.domain.model.Expense

fun ExpenseEntity.toDomain(category: Category): Expense = Expense(
    id = id,
    amountMinorUnits = amountMinorUnits,
    category = category,
    note = note,
    date = date,
    paymentMode = paymentMode,
    type = type
)

fun Expense.toEntity(): ExpenseEntity = ExpenseEntity(
    id = id,
    amountMinorUnits = amountMinorUnits,
    categoryId = category.id,
    note = note,
    date = date,
    paymentMode = paymentMode,
    type = type
)
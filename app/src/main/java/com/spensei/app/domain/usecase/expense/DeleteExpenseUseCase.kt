package com.spensei.app.domain.usecase.expense

import com.spensei.app.domain.model.Expense
import com.spensei.app.domain.repository.ExpenseRepository
import javax.inject.Inject

class DeleteExpenseUseCase @Inject constructor(
    private val repository: ExpenseRepository
) {
    suspend operator fun invoke(expense: Expense) = repository.deleteExpense(expense)
}
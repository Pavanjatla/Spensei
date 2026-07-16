package com.spensei.app.domain.usecase.expense

import com.spensei.app.domain.model.Expense
import com.spensei.app.domain.repository.ExpenseRepository
import javax.inject.Inject

class UpdateExpenseUseCase @Inject constructor(
    private val repository : ExpenseRepository
) {
    suspend operator fun invoke(expense : Expense) : Result<Unit> {
        if (expense.amountMinorUnits <= 0) {
            return Result.failure(IllegalArgumentException("Amount must be greater than zero"))
        }
        repository.updateExpense(expense)
        return Result.success(Unit)
    }
}
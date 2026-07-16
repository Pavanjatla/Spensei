package com.spensei.app.domain.usecase.expense

import com.spensei.app.domain.model.Expense
import com.spensei.app.domain.repository.ExpenseRepository
import javax.inject.Inject

class AddExpenseUseCase @Inject constructor(
    private val repository : ExpenseRepository
) {
    suspend operator fun invoke(expense : Expense) : Result<Long>{
        if (expense.amountMinorUnits <= 0) {
            return Result.failure(IllegalArgumentException("Amount must be greater than zero"))
        }
        if (expense.note.length > 200) {
            return Result.failure(IllegalArgumentException("Note is too long"))
        }
        val id = repository.addExpense(expense)
        return Result.success(id)
    }

}
package com.spensei.app.domain.usecase.expense

import com.spensei.app.domain.repository.ExpenseRepository
import javax.inject.Inject

class GetExpenseUseCase @Inject constructor(
    private val repository : ExpenseRepository
) {
    operator fun invoke() = repository.getAllExpenses()
}
package com.spensei.app.domain.model

data class Expense(
    val id: Long,
    val amountMinorUnits: Long,
    val category: Category,
    val note: String,
    val date: Long,
    val paymentMode: PaymentMode,
    val type: TransactionType
)

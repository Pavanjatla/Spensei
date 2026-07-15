package com.spensei.app.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.spensei.app.domain.model.PaymentMode
import com.spensei.app.domain.model.TransactionType

@Entity(
    tableName = "expenses" ,
    indices = [Index("categoryId"), Index("date")]
)
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val amountMinorUnits: Long,
    val categoryId: Long,
    val note: String,
    val date: Long,               // epoch millis
    val paymentMode: PaymentMode,
    val type: TransactionType
)

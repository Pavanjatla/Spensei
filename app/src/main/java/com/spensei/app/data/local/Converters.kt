package com.spensei.app.data.local

import androidx.room.TypeConverter
import com.spensei.app.domain.model.PaymentMode
import com.spensei.app.domain.model.TransactionType

 class Converters {
    @TypeConverter
    fun fromTransactionType (value : TransactionType) : String = value.name

    @TypeConverter
    fun toTransactionType (value : String) : TransactionType = TransactionType.valueOf(value)

    @TypeConverter
    fun fromPaymentMode(value : PaymentMode) : String = value.name

    @TypeConverter
    fun toPaymentMode (value : String) : PaymentMode = PaymentMode.valueOf(value)
}
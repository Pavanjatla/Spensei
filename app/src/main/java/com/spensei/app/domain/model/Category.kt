package com.spensei.app.domain.model

data class Category(
    val id: Long,
    val name: String,
    val icon: String,
    val colorHex: String,
    val isCustom: Boolean
)

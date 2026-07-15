package com.spensei.app.data.local

import com.spensei.app.data.local.entity.CategoryEntity

object DefaultCategories {

    val seed = listOf(
        CategoryEntity(name = "Food & Dining", icon = "🍔", colorHex = "#E76F51", isCustom = false),
        CategoryEntity(name = "Travel", icon = "🚕", colorHex = "#7FA88E", isCustom = false),
        CategoryEntity(name = "Bills", icon = "🧾", colorHex = "#1B4332", isCustom = false),
        CategoryEntity(name = "Shopping", icon = "🛍️", colorHex = "#C99A3C", isCustom = false),
        CategoryEntity(name = "Entertainment", icon = "🎬", colorHex = "#9A8C98", isCustom = false)
    )
}
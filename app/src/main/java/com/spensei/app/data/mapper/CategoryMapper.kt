package com.spensei.app.data.mapper

import com.spensei.app.data.local.entity.CategoryEntity
import com.spensei.app.domain.model.Category

fun CategoryEntity.toDomain() : Category = Category (
    id = id,
    name = name,
    icon = icon,
    colorHex = colorHex,
    isCustom = isCustom
)

fun Category.toEntity(): CategoryEntity = CategoryEntity(
    id = id,
    name = name,
    icon = icon,
    colorHex = colorHex,
    isCustom = isCustom
)
package com.spensei.app.data.repository

import com.spensei.app.data.local.dao.CategoryDao
import com.spensei.app.data.mapper.toDomain
import com.spensei.app.data.mapper.toEntity
import com.spensei.app.domain.model.Category
import com.spensei.app.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao : CategoryDao
) : CategoryRepository {
    override fun getAllCategories(): Flow<List<Category>> =
        categoryDao.getAllCategories().map { entities -> entities.map { it.toDomain() } }

    override suspend fun addCategory(category: Category): Long =
        categoryDao.insertCategory(category.toEntity())

    override suspend fun deleteCategory(category: Category) =
        categoryDao.deleteCategory(category.toEntity())
}
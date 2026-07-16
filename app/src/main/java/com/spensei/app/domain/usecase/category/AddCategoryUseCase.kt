package com.spensei.app.domain.usecase.category

import com.spensei.app.domain.model.Category
import com.spensei.app.domain.repository.CategoryRepository
import javax.inject.Inject

class AddCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(category: Category): Result<Long> {
        if (category.name.isBlank()) {
            return Result.failure(IllegalArgumentException("Category name cannot be empty"))
        }
        return Result.success(repository.addCategory(category))
    }
}
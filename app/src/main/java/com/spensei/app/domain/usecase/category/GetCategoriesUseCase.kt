package com.spensei.app.domain.usecase.category

import com.spensei.app.domain.repository.CategoryRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    operator fun invoke() = repository.getAllCategories()
}
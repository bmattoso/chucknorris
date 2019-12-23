package br.com.chucknorris.category.domain.usecase

import br.com.chucknorris.model.Category
import br.com.chucknorris.repository.category.CategoryRepository
import br.com.chucknorris.usecase.category.GetEventCategoryListUseCase
import javax.inject.Inject

class GetEventCategoryListUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetEventCategoryListUseCase {

    override fun invoke(): List<Category> {
        return categoryRepository.getAvailableCategories()
    }
}

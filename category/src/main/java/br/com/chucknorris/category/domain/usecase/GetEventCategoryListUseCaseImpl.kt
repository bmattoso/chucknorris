package br.com.chucknorris.category.domain.usecase

import br.com.chucknorris.model.Category
import br.com.chucknorris.repository.category.CategoryRepository
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.category.GetCategoriesAvailableFailure
import br.com.chucknorris.usecase.category.GetEventCategoryListUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetEventCategoryListUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetEventCategoryListUseCase {

    override fun invoke(): Single<Result<GetCategoriesAvailableFailure, List<Category>>> {
        return categoryRepository.getAvailableCategories()
    }
}

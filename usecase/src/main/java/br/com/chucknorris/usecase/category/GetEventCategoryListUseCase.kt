package br.com.chucknorris.usecase.category

import br.com.chucknorris.model.Category
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.category.GetCategoriesAvailableFailure
import io.reactivex.Single

interface GetEventCategoryListUseCase {
    operator fun invoke(): Single<Result<GetCategoriesAvailableFailure, List<Category>>>
}

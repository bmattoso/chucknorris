package br.com.chucknorris.repository.category

import br.com.chucknorris.model.Category
import br.com.chucknorris.repository.core.BaseRepository
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.category.GetCategoriesAvailableFailure
import io.reactivex.Single

abstract class CategoryRepository : BaseRepository() {
    abstract fun getAvailableCategories(): Single<Result<GetCategoriesAvailableFailure, List<Category>>>
}

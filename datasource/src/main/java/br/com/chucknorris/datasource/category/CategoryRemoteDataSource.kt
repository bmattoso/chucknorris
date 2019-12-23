package br.com.chucknorris.datasource.category

import br.com.chucknorris.model.Category
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.category.GetCategoriesAvailableFailure
import io.reactivex.Single

interface CategoryRemoteDataSource {
    fun getCategoriesAvailable(): Single<Result<GetCategoriesAvailableFailure, List<Category>>>
}

package br.com.chucknorris.category.domain.repository

import br.com.chucknorris.datasource.category.CategoryRemoteDataSource
import br.com.chucknorris.model.Category
import br.com.chucknorris.repository.category.CategoryRepository
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.category.GetCategoriesAvailableFailure
import io.reactivex.Single
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryRemoteDataSource: CategoryRemoteDataSource
) : CategoryRepository() {

    override fun getAvailableCategories(): Single<Result<GetCategoriesAvailableFailure, List<Category>>> {
        return if (networkAvailability.isAvailable()) {
            categoryRemoteDataSource.getCategoriesAvailable()
        } else {
            Single.just(Result.Error(GetCategoriesAvailableFailure.Connection))
        }
    }
}

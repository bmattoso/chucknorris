package br.com.chucknorris.category.domain.datasource

import br.com.chucknorris.coreui.scheduler.SchedulerProvider
import br.com.chucknorris.datasource.category.CategoryRemoteDataSource
import br.com.chucknorris.model.Category
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.category.GetCategoriesAvailableFailure
import br.com.chucknorris.service.category.CategoryService
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(
    private val categoryService: CategoryService,
    private val schedulerProvider: SchedulerProvider
) : CategoryRemoteDataSource {

    override fun getCategoriesAvailable(): Single<Result<GetCategoriesAvailableFailure, List<Category>>> {
        return categoryService.getAvailableCategories()
            .subscribeOn(schedulerProvider.io())
            .map { response -> transformResponseIntoResult(response) }
    }

    private fun transformResponseIntoResult(
        response: Response<List<String>>
    ) = if (response.isSuccessful) {
        Result.Success(
            createCategoryList(response.body())
        )
    } else {
        Result.Error(GetCategoriesAvailableFailure.Server)
    }

    private fun createCategoryList(categoriesResponse: List<String>?) = mutableListOf<Category>().apply {
        categoriesResponse?.forEachIndexed { index, categoryResponse ->
            add(createCategory(index + 1, categoryResponse))
        }
    }

    private fun createCategory(id: Int, categoryName: String) = Category(
        id = id.toLong(),
        name = categoryName
    )
}

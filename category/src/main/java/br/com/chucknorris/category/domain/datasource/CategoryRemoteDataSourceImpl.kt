package br.com.chucknorris.category.domain.datasource

import br.com.chucknorris.datasource.category.CategoryRemoteDataSource
import br.com.chucknorris.model.Category
import br.com.chucknorris.service.category.CategoryService
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(
    private val categoryService: CategoryService
) : CategoryRemoteDataSource {

    override fun getCategoriesAvailable(): List<Category> {
        return categoryService.getAvailableCategories()
    }
}

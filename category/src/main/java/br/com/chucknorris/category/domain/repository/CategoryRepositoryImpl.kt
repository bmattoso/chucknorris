package br.com.chucknorris.category.domain.repository

import br.com.chucknorris.datasource.category.CategoryRemoteDataSource
import br.com.chucknorris.model.Category
import br.com.chucknorris.repository.category.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryRemoteDataSource: CategoryRemoteDataSource
) : CategoryRepository() {

    override fun getAvailableCategories(): List<Category> {
        return categoryRemoteDataSource.getCategoriesAvailable()
    }
}

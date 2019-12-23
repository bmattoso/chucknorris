package br.com.chucknorris.datasource.category

import br.com.chucknorris.model.Category

interface CategoryRemoteDataSource {
    fun getCategoriesAvailable(): List<Category>
}

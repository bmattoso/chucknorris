package br.com.chucknorris.service.category

import br.com.chucknorris.model.Category
import retrofit2.http.GET

interface CategoryService {

    @GET("jokes/categories")
    fun getAvailableCategories(): List<Category>
}

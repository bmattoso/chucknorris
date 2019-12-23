package br.com.chucknorris.service.category

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {

    @GET("jokes/categories")
    fun getAvailableCategories(): Single<Response<List<String>>>
}

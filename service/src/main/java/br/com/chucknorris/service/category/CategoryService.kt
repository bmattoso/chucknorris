package br.com.chucknorris.service.category

import br.com.chucknorris.model.Category

interface CategoryService {
    fun getAvailableCategories(): List<Category>
}

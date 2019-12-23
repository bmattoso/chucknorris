package br.com.chucknorris.repository.category

import br.com.chucknorris.model.Category
import br.com.chucknorris.repository.core.BaseRepository

abstract class CategoryRepository : BaseRepository() {
    abstract fun getAvailableCategories(): List<Category>
}

package br.com.chucknorris.usecase.category

import br.com.chucknorris.model.Category

interface GetEventCategoryListUseCase {
    operator fun invoke(): List<Category>
}

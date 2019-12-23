package br.com.chucknorris.usecase.category

import br.com.chucknorris.usecase.core.BaseUseCase

interface GetEventCategoryListUseCase : BaseUseCase<Boolean> {
    suspend operator fun invoke(): Boolean
}

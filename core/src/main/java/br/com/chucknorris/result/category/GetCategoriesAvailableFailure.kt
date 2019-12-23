package br.com.chucknorris.result.category

sealed class GetCategoriesAvailableFailure {
    object Server : GetCategoriesAvailableFailure()
    object Connection : GetCategoriesAvailableFailure()
}

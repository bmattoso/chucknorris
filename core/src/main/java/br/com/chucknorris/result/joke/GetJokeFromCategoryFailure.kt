package br.com.chucknorris.result.joke

sealed class GetJokeFromCategoryFailure {
    object Connection : GetJokeFromCategoryFailure()
    object Server : GetJokeFromCategoryFailure()
}

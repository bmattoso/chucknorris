package br.com.chucknorris.result

sealed class Result<out Error, out Data> {
    data class Error<Error>(val error: Error) : Result<Error, Nothing>()
    data class Success<Data>(val data: Data) : Result<Nothing, Data>()

    fun onSuccess(onSuccess: (data: Data) -> Unit): Result<Error, Data> {
        if (this is Success) {
            onSuccess.invoke(data)
        }
        return this
    }

    fun onError(onError: (error: Error) -> Unit): Result<Error, Data> {
        if (this is Result.Error) {
            onError.invoke(error)
        }
        return this
    }
}

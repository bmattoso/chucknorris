package br.com.chucknorris.joke.di

import br.com.chucknorris.datasource.joke.JokeRemoteDataSource
import br.com.chucknorris.joke.domain.datasource.JokeRemoteDataSourceImpl
import br.com.chucknorris.joke.domain.repository.JokeRepositoryImpl
import br.com.chucknorris.joke.domain.usecase.GetJokeFromCategoryUseCaseImpl
import br.com.chucknorris.repository.joke.JokeRepository
import br.com.chucknorris.service.joke.JokeService
import br.com.chucknorris.usecase.joke.GetJokeFromCategoryUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class JokeDomainModule {

    @Provides
    fun bindGetEventCategoryListUseCase(
        getJokeFromCategoryUseCaseImpl: GetJokeFromCategoryUseCaseImpl
    ): GetJokeFromCategoryUseCase = getJokeFromCategoryUseCaseImpl

    @Provides
    fun bindJokeRepository(
        jokeRepositoryImpl: JokeRepositoryImpl
    ): JokeRepository = jokeRepositoryImpl

    @Provides
    fun bindJokeRemoteDataSource(
        jokeRemoteDataSourceImpl: JokeRemoteDataSourceImpl
    ): JokeRemoteDataSource = jokeRemoteDataSourceImpl

    @Provides
    fun providesJokeService(retrofit: Retrofit) = retrofit.create(JokeService::class.java)
}

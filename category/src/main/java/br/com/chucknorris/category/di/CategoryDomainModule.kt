package br.com.chucknorris.category.di

import br.com.chucknorris.category.domain.datasource.CategoryRemoteDataSourceImpl
import br.com.chucknorris.category.domain.repository.CategoryRepositoryImpl
import br.com.chucknorris.category.domain.usecase.GetEventCategoryListUseCaseImpl
import br.com.chucknorris.datasource.category.CategoryRemoteDataSource
import br.com.chucknorris.repository.category.CategoryRepository
import br.com.chucknorris.usecase.category.GetEventCategoryListUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class CategoryDomainModule {

    @Binds
    abstract fun bindGetEventCategoryListUseCase(
        getEventCategoryListUseCase: GetEventCategoryListUseCaseImpl
    ): GetEventCategoryListUseCase

    @Binds
    abstract fun bindCategoryRepository(
        categoryRepository: CategoryRepositoryImpl
    ): CategoryRepository

    @Binds
    abstract fun bindCategoryRemoteDataSource(
        categoryRemoteDataSource: CategoryRemoteDataSourceImpl
    ): CategoryRemoteDataSource
}

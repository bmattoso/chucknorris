package br.com.chucknorris.category.di

import br.com.chucknorris.category.domain.datasource.CategoryRemoteDataSourceImpl
import br.com.chucknorris.category.domain.repository.CategoryRepositoryImpl
import br.com.chucknorris.category.domain.usecase.GetEventCategoryListUseCaseImpl
import br.com.chucknorris.datasource.category.CategoryRemoteDataSource
import br.com.chucknorris.repository.category.CategoryRepository
import br.com.chucknorris.service.category.CategoryService
import br.com.chucknorris.usecase.category.GetEventCategoryListUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CategoryDomainModule {

    @Provides
    fun bindGetEventCategoryListUseCase(
        getEventCategoryListUseCase: GetEventCategoryListUseCaseImpl
    ): GetEventCategoryListUseCase = getEventCategoryListUseCase

    @Provides
    fun bindCategoryRepository(
        categoryRepository: CategoryRepositoryImpl
    ): CategoryRepository = categoryRepository

    @Provides
    fun bindCategoryRemoteDataSource(
        categoryRemoteDataSource: CategoryRemoteDataSourceImpl
    ): CategoryRemoteDataSource = categoryRemoteDataSource

    @Provides
    fun providesCategoryService(retrofit: Retrofit) = retrofit.create(CategoryService::class.java)
}

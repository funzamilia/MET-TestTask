package com.example.searchresults.di

import com.example.searchresults.data.SearchResultsApi
import com.example.searchresults.data.SearchResultsRemoteDataSource
import com.example.searchresults.data.SearchResultsRemoteDataSourceImpl
import com.example.searchresults.data.SearchResultsRepositoryImpl
import com.example.searchresults.domain.SearchResultsRepository
import com.example.searchresults.domain.usecase.GetQueryResultsUseCase
import com.example.searchresults.domain.usecase.GetQueryResultsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
abstract class SearchResultsModule {
    @Binds
    abstract fun bindSearchResultsRepository(
        impl: SearchResultsRepositoryImpl
    ): SearchResultsRepository

    @Binds
    abstract fun bindGetQueryResultsUseCase(
        impl: GetQueryResultsUseCaseImpl
    ): GetQueryResultsUseCase

    @Binds
    abstract fun bindSearchResultsRemoteDataSource(
        impl: SearchResultsRemoteDataSourceImpl
    ): SearchResultsRemoteDataSource

    companion object {
        @Provides
        fun provideSearchResultsApi(retrofit: Retrofit): SearchResultsApi = retrofit.create(
            SearchResultsApi::class.java
        )
    }
}
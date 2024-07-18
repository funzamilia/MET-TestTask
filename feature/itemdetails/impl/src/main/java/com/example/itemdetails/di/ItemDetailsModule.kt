package com.example.itemdetails.di

import com.example.itemdetails.data.ItemDetailsApi
import com.example.itemdetails.data.ItemDetailsRemoteDataSource
import com.example.itemdetails.data.ItemDetailsRemoteDataSourceImpl
import com.example.itemdetails.data.ItemDetailsRepositoryImpl
import com.example.itemdetails.domain.ItemDetailsRepository
import com.example.itemdetails.domain.usecase.GetItemDetailsUseCase
import com.example.itemdetails.domain.usecase.GetItemDetailsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
abstract class ItemDetailsModule {
    @Binds
    abstract fun bindItemDetailsRepository(
        impl: ItemDetailsRepositoryImpl
    ): ItemDetailsRepository

    @Binds
    abstract fun bindGetItemDetailsUseCase(
        impl: GetItemDetailsUseCaseImpl
    ): GetItemDetailsUseCase

    @Binds
    abstract fun bindItemDetailsRemoteDataSource(
        impl: ItemDetailsRemoteDataSourceImpl
    ): ItemDetailsRemoteDataSource

    companion object {
        @Provides
        fun provideItemDetailsApi(retrofit: Retrofit): ItemDetailsApi = retrofit.create(
            ItemDetailsApi::class.java
        )
    }
}
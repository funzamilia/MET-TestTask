package com.example.itemdetails.di

import com.example.itemdetails.data.ItemDetailsApi
import com.example.itemdetails.data.ItemDetailsRepositoryImpl
import com.example.itemdetails.domain.ItemDetailsRepository
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

    companion object {
        @Provides
        fun provideItemDetailsApi(retrofit: Retrofit): ItemDetailsApi = retrofit.create(
            ItemDetailsApi::class.java
        )
    }
}
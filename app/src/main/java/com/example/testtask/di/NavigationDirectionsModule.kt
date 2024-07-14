package com.example.testtask.di

import com.example.searchresults.view.navigation.SearchResultsNavigationDirectionsFactory
import com.example.testtask.navigation.SearchResultsNavigationDirectionsFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface NavigationDirectionsModule {
    @Binds
    fun bindSearchResultsNavigationDirectionsFactory(
        impl: SearchResultsNavigationDirectionsFactoryImpl
    ): SearchResultsNavigationDirectionsFactory
}
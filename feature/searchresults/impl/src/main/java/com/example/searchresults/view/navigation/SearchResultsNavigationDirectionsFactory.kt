package com.example.searchresults.view.navigation

import androidx.navigation.NavDirections

interface SearchResultsNavigationDirectionsFactory {
    fun provideItemDetailsDestination(itemId: String): NavDirections
}
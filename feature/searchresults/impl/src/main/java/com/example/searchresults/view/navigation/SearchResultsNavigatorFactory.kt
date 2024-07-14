package com.example.searchresults.view.navigation

import androidx.navigation.NavController
import javax.inject.Inject

class SearchResultsNavigatorFactory @Inject constructor(
    private val searchResultsNavigationDirectionsFactory: SearchResultsNavigationDirectionsFactory,
) {
    fun create(
        navController: NavController,
    ): SearchResultsNavigator {
        return SearchResultsNavigator(
            navController,
            searchResultsNavigationDirectionsFactory,
        )
    }
}
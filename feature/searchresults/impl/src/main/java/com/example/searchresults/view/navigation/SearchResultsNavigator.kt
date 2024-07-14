package com.example.searchresults.view.navigation

import androidx.navigation.NavController

class SearchResultsNavigator(
    private val navController: NavController,
    private val searchResultsNavigationDirectionsFactory: SearchResultsNavigationDirectionsFactory,
) {
    fun handleNavigationEvent(event: SearchResultsNavigationEvent) {
        when (event) {
            is SearchResultsNavigationEvent.NavigateToItemDetails -> handleNavigateToItemDetails(event.itemId)
        }
    }

    private fun handleNavigateToItemDetails(itemId: String) {
        val destination = searchResultsNavigationDirectionsFactory.provideItemDetailsDestination(itemId)
        navController.navigate(destination)
    }
}

sealed class SearchResultsNavigationEvent {
    data class NavigateToItemDetails(val itemId: String) : SearchResultsNavigationEvent()
}
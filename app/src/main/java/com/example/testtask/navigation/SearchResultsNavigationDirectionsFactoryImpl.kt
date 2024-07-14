package com.example.testtask.navigation

import androidx.navigation.NavDirections
import com.example.searchresults.view.SearchResultsFragmentDirections
import com.example.searchresults.view.navigation.SearchResultsNavigationDirectionsFactory
import javax.inject.Inject

class SearchResultsNavigationDirectionsFactoryImpl @Inject constructor() : SearchResultsNavigationDirectionsFactory {
    override fun provideItemDetailsDestination(itemId: String): NavDirections {
        return SearchResultsFragmentDirections.actionSearchResultsFragmentToItemDetailsFragment(
            itemId
        )
    }
}
package com.example.searchresults.testdata

import androidx.navigation.NavDirections
import com.example.searchresults.view.navigation.SearchResultsNavigationDirectionsFactory

class SearchResultsNavigationDirectionsFactoryFake : SearchResultsNavigationDirectionsFactory {
    var result: NavDirections? = null
    var calledWithItemId: String? = null
        private set

    override fun provideItemDetailsDestination(itemId: String): NavDirections {
        calledWithItemId = itemId
        return result!!
    }
}
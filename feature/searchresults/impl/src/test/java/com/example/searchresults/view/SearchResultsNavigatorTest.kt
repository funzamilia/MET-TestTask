package com.example.searchresults.view

import androidx.navigation.NavController
import com.example.searchresults.testdata.NavDirectionsFake
import com.example.searchresults.testdata.SearchResultsNavigationDirectionsFactoryFake
import com.example.searchresults.view.navigation.SearchResultsNavigationEvent
import com.example.searchresults.view.navigation.SearchResultsNavigator
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SearchResultsNavigatorTest {
    private val navControllerMock: NavController = mockk(relaxed = true)
    private val searchResultsNavigationDirectionsFactoryFake =
        SearchResultsNavigationDirectionsFactoryFake()

    private val navigatorUnderTest = SearchResultsNavigator(
        navControllerMock,
        searchResultsNavigationDirectionsFactoryFake,
    )

    @Test
    fun `handleNavigationEvent(NavigateToItemDetails) navigates to item details`() {
        val itemId = "itemId"
        val navDirectionsFake = NavDirectionsFake()
        searchResultsNavigationDirectionsFactoryFake.result = navDirectionsFake

        navigatorUnderTest.handleNavigationEvent(SearchResultsNavigationEvent.NavigateToItemDetails(itemId))

        assertEquals(itemId, searchResultsNavigationDirectionsFactoryFake.calledWithItemId)
        verify { navControllerMock.navigate(navDirectionsFake) }
    }
}
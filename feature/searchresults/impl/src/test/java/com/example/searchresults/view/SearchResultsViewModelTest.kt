package com.example.searchresults.view

import com.example.searchresults.testdata.GetQueryResultsUseCaseFake
import com.example.searchresults.view.model.SearchResultsUiEvent
import com.example.searchresults.view.model.SearchResultsUiState
import com.example.searchresults.view.navigation.SearchResultsNavigationEvent
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchResultsViewModelTest {
    private val getQueryResultsUseCaseFake = GetQueryResultsUseCaseFake()
    private val uiStateFactory = SearchResultsUiStateFactory()

    private val viewModelUnderTest = SearchResultsViewModel(
        getQueryResultsUseCaseFake,
        uiStateFactory,
    )

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `handleUiState(Search) runs search`() = runTest {
        val query = "query"
        getQueryResultsUseCaseFake.result = listOf(1, 2, 3)

        viewModelUnderTest.handleUiEvent(SearchResultsUiEvent.Search(query))

        viewModelUnderTest.uiState.first().let {
            assertEquals(
                SearchResultsUiState(
                    results = listOf("1", "2", "3"),
                    searchQuery = query,
                    isLoading = false,
                    displayMessage = ""
                ),
                it
            )
        }

        assertEquals(query, getQueryResultsUseCaseFake.calledWithQuery)
    }

    @Test
    fun `handleUiState(ItemClicked) navigates to item details`() = runTest {
        val itemId = "itemId"
        viewModelUnderTest.handleUiEvent(SearchResultsUiEvent.ItemClicked(itemId))

        assertEquals(
            SearchResultsNavigationEvent.NavigateToItemDetails(itemId),
            viewModelUnderTest.navEvents.first(),
        )
    }
}
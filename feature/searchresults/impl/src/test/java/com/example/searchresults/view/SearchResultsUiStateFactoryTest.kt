package com.example.searchresults.view

import com.example.searchresults.view.model.SearchResultsUiState
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class SearchResultsUiStateFactoryTest(private val params: TestCase) {
    private val factoryUnderTest = SearchResultsUiStateFactory()

    @Test
    fun `createInitialState() should return initial state`() {
        val actual = factoryUnderTest.createInitialState()

        assertEquals(SearchResultsUiState(displayMessage = "Please start typing"), actual)
    }

    @Test
    fun `createUiState() should return expected state`() {
        val actual = factoryUnderTest.createUiState(params.results, params.currentQuery)

        assertEquals(params.expected, actual)
    }

    companion object {

        @JvmStatic
        @Parameters
        fun params() = listOf(
            TestCase(
                results = emptyList(),
                currentQuery = "",
                expected = SearchResultsUiState(
                    displayMessage = "Please start typing"
                )
            ),
            TestCase(
                results = listOf(1, 2, 3),
                currentQuery = "query",
                expected = SearchResultsUiState(
                    results = listOf("1", "2", "3"),
                    searchQuery = "query",
                    isLoading = false,
                    displayMessage = ""
                )
            ),
            TestCase(
                results = emptyList(),
                currentQuery = "query",
                expected = SearchResultsUiState(
                    results = emptyList(),
                    searchQuery = "query",
                    isLoading = false,
                    displayMessage = "No matching results found"
                )
            ),
            TestCase(
                results = null,
                currentQuery = "query",
                expected = SearchResultsUiState(
                    results = emptyList(),
                    searchQuery = "query",
                    isLoading = false,
                    displayMessage = "There was an error fetching the results"
                )
            ),
        )
    }

    data class TestCase(
        val results: List<Int>?,
        val currentQuery: String,
        val expected: SearchResultsUiState,
    )
}
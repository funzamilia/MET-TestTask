package com.example.searchresults.view

import com.example.searchresults.view.model.SearchResultsUiState
import javax.inject.Inject

class SearchResultsUiStateFactory @Inject constructor() {
    fun createInitialState(): SearchResultsUiState {
        return SearchResultsUiState(
            displayMessage = "Please start typing"
        )
    }

    fun createUiState(results: List<Int>?, currentQuery: String): SearchResultsUiState {
        return results?.let { resultValues ->
            SearchResultsUiState(
                results = resultValues.map { it.toString() },
                searchQuery = currentQuery,
                isLoading = false,
                displayMessage = createDisplayMessage(
                    currentQuery.isEmpty(),
                    resultValues.isEmpty()
                )
            )
        } ?: SearchResultsUiState(
            results = emptyList(),
            searchQuery = currentQuery,
            isLoading = false,
            displayMessage = "There was an error fetching the results",
        )
    }

    private fun createDisplayMessage(emptyQuery: Boolean, emptyResults: Boolean): String {
        return if (emptyQuery) {
            "Please start typing"
        } else if (emptyResults) {
            "No matching results found"
        } else ""
    }
}
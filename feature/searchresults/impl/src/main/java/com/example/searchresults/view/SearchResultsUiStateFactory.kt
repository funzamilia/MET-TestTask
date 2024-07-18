package com.example.searchresults.view

import com.example.core.util.ResourceLoader
import com.example.searchresults.R
import com.example.searchresults.view.model.SearchResultsUiState
import javax.inject.Inject

class SearchResultsUiStateFactory @Inject constructor(
    private val resourceLoader: ResourceLoader,
) {
    fun createInitialState(): SearchResultsUiState {
        return SearchResultsUiState(
            displayMessage = resourceLoader.getString(R.string.search_results_please_start_typing)
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
            displayMessage = resourceLoader.getString(R.string.search_results_error_fetching_results),
        )
    }

    private fun createDisplayMessage(emptyQuery: Boolean, emptyResults: Boolean): String {
        return if (emptyQuery) {
            resourceLoader.getString(R.string.search_results_please_start_typing)
        } else if (emptyResults) {
            resourceLoader.getString(R.string.search_results_no_matching_results)
        } else ""
    }
}
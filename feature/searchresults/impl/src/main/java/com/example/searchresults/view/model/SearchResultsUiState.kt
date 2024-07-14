package com.example.searchresults.view.model

sealed class SearchResultsUiState {
    open val searchQuery: String = ""

    data class Content(
        val results: List<String>,
        override val searchQuery: String,
    ) : SearchResultsUiState()

    data class Loading(
        override val searchQuery: String,
    ) : SearchResultsUiState()

    data class Error(
        val exception: Exception,
        override val searchQuery: String,
    ) : SearchResultsUiState()
}
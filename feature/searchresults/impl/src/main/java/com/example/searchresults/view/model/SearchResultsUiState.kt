package com.example.searchresults.view.model

data class SearchResultsUiState(
    val isLoading: Boolean = false,
    val displayMessage: String = "",
    val results: List<String> = emptyList(),
    val searchQuery: String = "",
)
package com.example.searchresults.view.model

data class SearchResultsUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val results: List<String> = emptyList(),
    val searchQuery: String = "",
)
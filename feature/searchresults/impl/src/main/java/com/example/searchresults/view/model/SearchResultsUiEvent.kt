package com.example.searchresults.view.model

sealed class SearchResultsUiEvent {
    data class Search(val query: String) : SearchResultsUiEvent()
}
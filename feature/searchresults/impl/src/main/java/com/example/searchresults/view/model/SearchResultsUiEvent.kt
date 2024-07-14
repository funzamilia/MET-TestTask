package com.example.searchresults.view.model

sealed class SearchResultsUiEvent {
    data class Search(val query: String) : SearchResultsUiEvent()
    data class ItemClicked(val itemId: String) : SearchResultsUiEvent()
}
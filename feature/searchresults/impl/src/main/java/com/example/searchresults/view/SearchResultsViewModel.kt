package com.example.searchresults.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchresults.domain.usecase.GetQueryResultsUseCase
import com.example.searchresults.view.model.SearchResultsUiEvent
import com.example.searchresults.view.model.SearchResultsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultsViewModel @Inject constructor(
    private val getQueryResultsUseCase: GetQueryResultsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(SearchResultsUiState())
    val uiState: StateFlow<SearchResultsUiState> = _uiState

    fun handleUiEvent(event: SearchResultsUiEvent) {
        when (event) {
            is SearchResultsUiEvent.Search -> handleSearch(event.query)
        }
    }

    private fun handleSearch(query: String) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val queryResult = getQueryResultsUseCase(query)
            _uiState.value = SearchResultsUiState(results = queryResult, isLoading = false)
        }
    }
}
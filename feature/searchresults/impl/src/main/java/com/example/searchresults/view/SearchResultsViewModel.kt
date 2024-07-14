package com.example.searchresults.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchresults.domain.usecase.GetQueryResultsUseCase
import com.example.searchresults.view.model.SearchResultsUiEvent
import com.example.searchresults.view.model.SearchResultsUiState
import com.example.searchresults.view.navigation.SearchResultsNavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultsViewModel @Inject constructor(
    private val getQueryResultsUseCase: GetQueryResultsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(SearchResultsUiState())
    val uiState: StateFlow<SearchResultsUiState> = _uiState

    private val navigationEventsChannel = Channel<SearchResultsNavigationEvent>(Channel.UNLIMITED)
    val navEvents = navigationEventsChannel.receiveAsFlow()

    fun handleUiEvent(event: SearchResultsUiEvent) {
        when (event) {
            is SearchResultsUiEvent.Search -> handleSearch(event.query)
            is SearchResultsUiEvent.ItemClicked -> handleItemClicked(event.itemId)
        }
    }

    private fun handleSearch(query: String) {
        _uiState.update { it.copy(searchQuery = query, isLoading = true) }
        viewModelScope.launch {
            val queryResult = getQueryResultsUseCase(query)
            _uiState.update { uiState ->
                uiState.copy(
                    results = queryResult.map { it.toString() },
                    isLoading = false
                )
            }
        }
    }

    private fun handleItemClicked(itemId: String) {
        navigationEventsChannel.trySend(SearchResultsNavigationEvent.NavigateToItemDetails(itemId))
    }
}
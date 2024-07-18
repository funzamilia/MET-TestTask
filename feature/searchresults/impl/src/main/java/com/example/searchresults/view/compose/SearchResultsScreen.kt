package com.example.searchresults.view.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.searchresults.view.model.SearchResultsUiEvent
import com.example.searchresults.view.model.SearchResultsUiState

@Composable
fun SearchResultsScreen(
    handleUiEvent: (SearchResultsUiEvent) -> Unit,
    uiState: SearchResultsUiState,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        TextField(
            value = uiState.searchQuery,
            onValueChange = { handleUiEvent(SearchResultsUiEvent.Search(it)) },
            placeholder = { Text("Search") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = ""
                )
            },
            modifier = Modifier.fillMaxWidth(),
        )

        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp)
                ) {
                    LinearProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            uiState.displayMessage.isNotEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Text(
                        text = uiState.displayMessage,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }

            else -> SearchResultsContent(
                { handleUiEvent(SearchResultsUiEvent.ItemClicked(it)) },
                uiState
            )
        }
    }
}
package com.example.searchresults.view.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.searchresults.view.model.SearchResultsUiState

@Composable
fun SearchResultsContent(
    handleItemClicked: (String) -> Unit,
    uiState: SearchResultsUiState,
    ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 8.dp),
    ) {
        repeat(3) {
            item {
                Spacer(
                    modifier = Modifier
                        .heightIn(16.dp)
                )
            }
        }
        items(uiState.results) { result ->
            Card(
                onClick = { handleItemClicked(result) }
            ) {
                Text(
                    text = result,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                )
            }
        }
        repeat(3) {
            item {
                Spacer(
                    modifier = Modifier
                        .heightIn(16.dp)
                )
            }
        }
    }
}
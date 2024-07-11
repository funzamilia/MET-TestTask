package com.example.searchresults.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.searchresults.view.model.SearchResultsUiEvent

class SearchResultsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val viewModel: SearchResultsViewModel by viewModels()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                TextField(
                    value = uiState.searchQuery,
                    onValueChange = { viewModel.handleUiEvent(SearchResultsUiEvent.Search(it)) },
                    placeholder = { Text("Search") },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = ""
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                )
                LazyColumn {
                    items(uiState.results) { result ->
                        Text(result)
                    }
                }
            }
        }
    }
}
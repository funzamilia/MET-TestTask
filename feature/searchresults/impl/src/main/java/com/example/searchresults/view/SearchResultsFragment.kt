package com.example.searchresults.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.searchresults.view.model.SearchResultsUiEvent
import com.example.searchresults.view.navigation.SearchResultsNavigatorFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SearchResultsFragment : Fragment() {

    @Inject
    lateinit var searchResultsNavigatorFactory: SearchResultsNavigatorFactory

    private val viewModel: SearchResultsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
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
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.align(Alignment.Center),
                                )
                            }
                        }

                        else -> {
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
                                        onClick = {
                                            viewModel.handleUiEvent(
                                                SearchResultsUiEvent.ItemClicked(result)
                                            )
                                        }
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
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navigator = searchResultsNavigatorFactory.create(findNavController())

        lifecycleScope.launch {
            viewModel.navEvents.collect { event ->
                navigator.handleNavigationEvent(event)
            }
        }
    }
}
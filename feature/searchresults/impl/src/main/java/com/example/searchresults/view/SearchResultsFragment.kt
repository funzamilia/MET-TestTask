package com.example.searchresults.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.searchresults.view.compose.SearchResultsScreen
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
                SearchResultsScreen(
                    handleUiEvent = { viewModel.handleUiEvent(it) },
                    uiState = uiState,
                )
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
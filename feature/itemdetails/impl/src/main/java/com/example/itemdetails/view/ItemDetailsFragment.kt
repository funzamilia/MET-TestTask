package com.example.itemdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.itemdetails.view.model.ItemDetailsUiState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.withCreationCallback

@AndroidEntryPoint
class ItemDetailsFragment : Fragment() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val itemId = arguments?.getString("itemId")
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val viewModel: ItemDetailsViewModel by viewModels(
                    extrasProducer = {
                        defaultViewModelCreationExtras.withCreationCallback<ItemDetailsViewModel.Factory> {
                            it.create(itemId)
                        }
                    }
                )
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                when (val stableUiState = uiState) {
                    is ItemDetailsUiState.Content -> {
                        val item = stableUiState.item

                        val pagerState =
                            rememberPagerState(pageCount = { item.additionalImages.size + 1 })

                        Column {
                            HorizontalPager(
                                state = pagerState,
                                pageSpacing = 8.dp,
                            ) {
                                AsyncImage(
                                    model = item.primaryImage,
                                    contentDescription = "",
                                    contentScale = ContentScale.Fit,
                                )
                                item.additionalImages.forEach {
                                    AsyncImage(
                                        model = it,
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                    )
                                }
                            }

                            Text(item.title)
                        }
                    }

                    is ItemDetailsUiState.Loading -> {
                        Text("Loading")
                    }

                    is ItemDetailsUiState.Error -> {
                        stableUiState.exception.message?.let {
                            Text(it)
                        }
                    }
                }

            }
        }
    }
}
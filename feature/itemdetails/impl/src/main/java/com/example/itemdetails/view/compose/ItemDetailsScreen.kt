package com.example.itemdetails.view.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.itemdetails.R
import com.example.itemdetails.view.ItemDetailsViewModel
import com.example.itemdetails.view.model.ItemDetailsUiState

@Composable
fun ItemDetailsScreen(viewModel: ItemDetailsViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val stableUiState = uiState) {
        is ItemDetailsUiState.Content -> {
            ItemDetailsContent(uiState = stableUiState)
        }

        is ItemDetailsUiState.Loading -> {
            Text(
                stringResource(R.string.item_details_loading),
                modifier = Modifier.padding(16.dp),
            )
        }

        is ItemDetailsUiState.Error -> {
            stableUiState.exception.message?.let {
                Text(it, modifier = Modifier.padding(16.dp))
            }
        }
    }
}
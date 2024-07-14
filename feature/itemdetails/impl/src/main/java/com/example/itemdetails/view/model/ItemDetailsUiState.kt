package com.example.itemdetails.view.model

import com.example.itemdetails.domain.model.ItemDetails

sealed class ItemDetailsUiState {
    data class Content(val item: ItemDetails) : ItemDetailsUiState()
    data object Loading : ItemDetailsUiState()
    data class Error(val exception: Exception) : ItemDetailsUiState()
}
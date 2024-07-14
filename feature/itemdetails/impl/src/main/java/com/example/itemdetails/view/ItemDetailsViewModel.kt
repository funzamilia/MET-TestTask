package com.example.itemdetails.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itemdetails.domain.usecase.GetItemDetailsUseCase
import com.example.itemdetails.view.model.ItemDetailsUiState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = ItemDetailsViewModel.Factory::class)
class ItemDetailsViewModel @AssistedInject constructor(
    @Assisted private val itemId: String?,
    private val getItemDetailsUseCase: GetItemDetailsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<ItemDetailsUiState>(ItemDetailsUiState.Loading)
    val uiState: StateFlow<ItemDetailsUiState> = _uiState

    init {
        itemId?.let {
            viewModelScope.launch {
                val itemDetails = getItemDetailsUseCase(itemId)
                itemDetails?.let {
                    _uiState.value = ItemDetailsUiState.Content(item = itemDetails)
                } ?: run {
                    _uiState.value = ItemDetailsUiState.Error(Exception("Item could not be loaded"))
                }
            }
        } ?: run {
            _uiState.value = ItemDetailsUiState.Error(Exception("No item id found"))
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(itemId: String?): ItemDetailsViewModel
    }
}
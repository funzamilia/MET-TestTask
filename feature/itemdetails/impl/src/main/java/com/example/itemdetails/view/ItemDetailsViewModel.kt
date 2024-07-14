package com.example.itemdetails.view

import androidx.lifecycle.ViewModel
import com.example.itemdetails.domain.usecase.GetItemDetailsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = ItemDetailsViewModel.Factory::class)
class ItemDetailsViewModel @AssistedInject constructor(
    @Assisted private val itemId: String?,
    private val getItemDetailsUseCase: GetItemDetailsUseCase,
) : ViewModel() {


    @AssistedFactory
    interface Factory {
        fun create(itemId: String?): ItemDetailsViewModel
    }
}
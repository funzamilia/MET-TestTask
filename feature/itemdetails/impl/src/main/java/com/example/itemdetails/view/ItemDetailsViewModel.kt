package com.example.itemdetails.view

import androidx.lifecycle.ViewModel
import com.example.itemdetails.domain.usecase.GetItemDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    private val getItemDetailsUseCase: GetItemDetailsUseCase,
) : ViewModel() {

}
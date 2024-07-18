package com.example.itemdetails.domain.usecase

import com.example.itemdetails.domain.model.ItemDetails

interface GetItemDetailsUseCase {
    suspend operator fun invoke(objectId: String): ItemDetails?
}
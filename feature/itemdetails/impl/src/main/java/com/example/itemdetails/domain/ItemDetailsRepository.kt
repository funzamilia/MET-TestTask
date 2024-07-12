package com.example.itemdetails.domain

import com.example.itemdetails.domain.model.ItemDetails

interface ItemDetailsRepository {
    suspend fun getItemDetails(objectId: String): ItemDetails?
}
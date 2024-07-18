package com.example.itemdetails.data

import com.example.itemdetails.data.model.ItemDetailsEntity
import com.example.network.model.ErrorResponse
import com.example.network.model.NetworkResponse

interface ItemDetailsRemoteDataSource {
    suspend fun getItemDetails(objectId: String): NetworkResponse<ItemDetailsEntity, ErrorResponse>
}
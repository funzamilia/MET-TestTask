package com.example.itemdetails.data

import javax.inject.Inject

class ItemDetailsRemoteDataSource @Inject constructor(
    private val itemDetailsApi: ItemDetailsApi,
) {
    suspend fun getItemDetails(objectId: String) = itemDetailsApi.getItemDetails(objectId)
}
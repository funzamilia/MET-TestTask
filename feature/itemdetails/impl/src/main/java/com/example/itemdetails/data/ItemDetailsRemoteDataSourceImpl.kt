package com.example.itemdetails.data

import javax.inject.Inject

class ItemDetailsRemoteDataSourceImpl @Inject constructor(
    private val itemDetailsApi: ItemDetailsApi,
) : ItemDetailsRemoteDataSource {
    override suspend fun getItemDetails(objectId: String) = itemDetailsApi.getItemDetails(objectId)
}
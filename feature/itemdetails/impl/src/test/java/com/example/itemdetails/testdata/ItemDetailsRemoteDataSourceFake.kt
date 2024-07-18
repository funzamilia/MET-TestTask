package com.example.itemdetails.testdata

import com.example.itemdetails.data.ItemDetailsRemoteDataSource
import com.example.itemdetails.data.model.ItemDetailsEntity
import com.example.network.model.ErrorResponse
import com.example.network.model.NetworkResponse

class ItemDetailsRemoteDataSourceFake : ItemDetailsRemoteDataSource {
    var result: NetworkResponse<ItemDetailsEntity, ErrorResponse>? = null
    var calledWithObjectId: String? = null
        private set

    override suspend fun getItemDetails(objectId: String): NetworkResponse<ItemDetailsEntity, ErrorResponse> {
        calledWithObjectId = objectId
        return result!!
    }
}
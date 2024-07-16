package com.example.itemdetails.data

import com.example.itemdetails.data.model.ItemDetailsEntity
import com.example.network.model.ErrorResponse
import com.example.network.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ItemDetailsApi {
    @GET("objects/{objectId}")
    suspend fun getItemDetails(@Path("objectId") objectId: String): NetworkResponse<ItemDetailsEntity, ErrorResponse>
}
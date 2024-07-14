package com.example.itemdetails.data

import com.example.itemdetails.data.model.ItemDetailsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ItemDetailsApi {
    @GET("objects/{objectId}")
    suspend fun getItemDetails(@Path("objectId") objectId: String): Response<ItemDetailsEntity>
}
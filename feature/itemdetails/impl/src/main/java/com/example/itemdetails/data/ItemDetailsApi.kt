package com.example.itemdetails.data

import com.example.itemdetails.data.model.ItemDetailsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemDetailsApi {
    @GET("objects/")
    suspend fun getItemDetails(@Query("objectId") q: String): Response<ItemDetailsEntity>
}
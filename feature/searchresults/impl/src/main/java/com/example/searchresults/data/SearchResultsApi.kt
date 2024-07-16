package com.example.searchresults.data

import com.example.network.model.ErrorResponse
import com.example.network.model.NetworkResponse
import com.example.searchresults.data.model.SearchResultsEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchResultsApi {
    @GET("search")
    suspend fun getQueryResults(@Query("q") q: String): NetworkResponse<SearchResultsEntity, ErrorResponse>
}
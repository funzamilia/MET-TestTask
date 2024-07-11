package com.example.searchresults.data

import com.example.searchresults.data.model.SearchResults
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchResultsApi {
    @GET("search")
    suspend fun getQueryResults(@Query("q") q: String): Response<SearchResults>
}
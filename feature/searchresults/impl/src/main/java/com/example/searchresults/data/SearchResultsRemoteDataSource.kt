package com.example.searchresults.data

import com.example.network.model.ErrorResponse
import com.example.network.model.NetworkResponse
import com.example.searchresults.data.model.SearchResultsEntity

interface SearchResultsRemoteDataSource {
    suspend fun getQueryResults(query: String): NetworkResponse<SearchResultsEntity, ErrorResponse>
}
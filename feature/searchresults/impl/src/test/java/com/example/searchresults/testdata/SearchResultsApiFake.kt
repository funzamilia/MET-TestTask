package com.example.searchresults.testdata

import com.example.network.model.ErrorResponse
import com.example.network.model.NetworkResponse
import com.example.searchresults.data.SearchResultsApi
import com.example.searchresults.data.model.SearchResultsEntity

class SearchResultsApiFake : SearchResultsApi {
    var queryResults: NetworkResponse<SearchResultsEntity, ErrorResponse>? = null
    var calledWithQ: String? = null
        private set

    override suspend fun getQueryResults(q: String): NetworkResponse<SearchResultsEntity, ErrorResponse> {
        calledWithQ = q
        return queryResults!!
    }
}
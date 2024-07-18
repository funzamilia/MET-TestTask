package com.example.searchresults.testdata

import com.example.network.model.ErrorResponse
import com.example.network.model.NetworkResponse
import com.example.searchresults.data.SearchResultsRemoteDataSource
import com.example.searchresults.data.model.SearchResultsEntity

class SearchResultsRemoteDataSourceFake : SearchResultsRemoteDataSource {
    var queryResults: NetworkResponse<SearchResultsEntity, ErrorResponse>? = null
    var calledWithQuery: String? = null
        private set

    override suspend fun getQueryResults(query: String): NetworkResponse<SearchResultsEntity, ErrorResponse> {
        calledWithQuery = query
        return queryResults!!
    }
}
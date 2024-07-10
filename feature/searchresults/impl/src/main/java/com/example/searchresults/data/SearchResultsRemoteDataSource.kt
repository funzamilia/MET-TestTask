package com.example.searchresults.data

import javax.inject.Inject

class SearchResultsRemoteDataSource @Inject constructor(
    private val searchResultsApi: SearchResultsApi,
) {
    fun getQueryResults(query: String) = searchResultsApi.getQueryResults(query)
}
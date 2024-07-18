package com.example.searchresults.data

import javax.inject.Inject

class SearchResultsRemoteDataSourceImpl @Inject constructor(
    private val searchResultsApi: SearchResultsApi,
) : SearchResultsRemoteDataSource {
    override suspend fun getQueryResults(query: String) = searchResultsApi.getQueryResults(query)
}
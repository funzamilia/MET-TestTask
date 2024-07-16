package com.example.searchresults.data

import com.example.network.model.NetworkResponse
import com.example.searchresults.domain.SearchResultsRepository
import javax.inject.Inject

class SearchResultsRepositoryImpl @Inject constructor(
    private val searchResultsRemoteDataSource: SearchResultsRemoteDataSource,
) : SearchResultsRepository {
    override suspend fun getQueryResults(query: String): List<Int>? {
        return when (val result = searchResultsRemoteDataSource.getQueryResults(query)) {
            is NetworkResponse.Success -> result.body.objectIDs
            else -> null
        }
    }
}
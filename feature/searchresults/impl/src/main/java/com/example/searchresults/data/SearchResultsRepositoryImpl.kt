package com.example.searchresults.data

import com.example.searchresults.domain.SearchResultsRepository
import javax.inject.Inject

class SearchResultsRepositoryImpl @Inject constructor(
    private val searchResultsRemoteDataSource: SearchResultsRemoteDataSource,
) : SearchResultsRepository {
    override suspend fun getQueryResults(query: String): List<String> {
        val result = searchResultsRemoteDataSource.getQueryResults(query).body()
        return result?.objectIDs ?: emptyList()
    }
}
package com.example.searchresults.testdata

import com.example.searchresults.domain.SearchResultsRepository

class SearchResultsRepositoryFake : SearchResultsRepository {
    var queryResults: List<Int>? = null
    var calledWithQuery: String? = null
        private set

    override suspend fun getQueryResults(query: String): List<Int>? {
        calledWithQuery = query
        return queryResults
    }
}
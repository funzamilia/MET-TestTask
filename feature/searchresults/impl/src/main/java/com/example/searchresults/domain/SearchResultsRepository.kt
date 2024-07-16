package com.example.searchresults.domain

interface SearchResultsRepository {
    suspend fun getQueryResults(query: String): List<Int>?
}
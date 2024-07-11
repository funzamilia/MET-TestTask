package com.example.searchresults.domain.usecase

import com.example.searchresults.domain.SearchResultsRepository
import javax.inject.Inject

class GetQueryResultsUseCase @Inject constructor(
    private val searchResultsRepository: SearchResultsRepository
) {
    suspend operator fun invoke(query: String): List<String> {
        return searchResultsRepository.getQueryResults(query)
    }
}
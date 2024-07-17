package com.example.searchresults.domain.usecase

import com.example.searchresults.domain.SearchResultsRepository
import javax.inject.Inject

class GetQueryResultsUseCaseImpl @Inject constructor(
    private val searchResultsRepository: SearchResultsRepository
) : GetQueryResultsUseCase {
    override suspend operator fun invoke(query: String): List<Int>? {
        return searchResultsRepository.getQueryResults(query)
    }
}
package com.example.searchresults.testdata

import com.example.searchresults.domain.usecase.GetQueryResultsUseCase

class GetQueryResultsUseCaseFake : GetQueryResultsUseCase {
    var result: List<Int>? = null
    var calledWithQuery: String? = null
        private set

    override suspend fun invoke(query: String): List<Int>? {
        calledWithQuery = query
        return result
    }
}
package com.example.searchresults.domain.usecase

interface GetQueryResultsUseCase {
    suspend operator fun invoke(query: String): List<Int>?
}
package com.example.searchresults.domain.usecase

import com.example.searchresults.testdata.SearchResultsRepositoryFake
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetQueryResultsUseCaseImplTest {
    private val searchResultsRepositoryFake = SearchResultsRepositoryFake()

    private val useCaseUnderTest = GetQueryResultsUseCaseImpl(searchResultsRepositoryFake)

    @Test
    fun `invoke() delegates to repository`() = runTest {
        val query = "query"
        val expectedResult = listOf(1, 2, 3)
        searchResultsRepositoryFake.queryResults = expectedResult

        val result = useCaseUnderTest.invoke(query)

        assertEquals(expectedResult, result)
        assertEquals(query, searchResultsRepositoryFake.calledWithQuery)
    }
}
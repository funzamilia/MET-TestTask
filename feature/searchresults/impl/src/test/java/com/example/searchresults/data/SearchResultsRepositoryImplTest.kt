package com.example.searchresults.data

import com.example.network.model.NetworkResponse
import com.example.searchresults.testdata.SearchResultsEntityStub
import com.example.searchresults.testdata.SearchResultsRemoteDataSourceFake
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.test.runTest
import org.junit.Test

private const val QUERY = "query"

class SearchResultsRepositoryImplTest {
    private val searchResultsRemoteDataSourceFake = SearchResultsRemoteDataSourceFake()

    private val repositoryUnderTest = SearchResultsRepositoryImpl(searchResultsRemoteDataSourceFake)

    @Test
    fun `getQueryResults() returns objectIds when available`() = runTest {
        val expectedResult = listOf(1, 2, 3)
        searchResultsRemoteDataSourceFake.queryResults =
            NetworkResponse.Success(SearchResultsEntityStub())

        val result = repositoryUnderTest.getQueryResults(QUERY)

        assertEquals(expectedResult, result)
        assertEquals(QUERY, searchResultsRemoteDataSourceFake.calledWithQuery)
    }

    @Test
    fun `getQueryResults() returns empty list when total = 0`() = runTest {
        searchResultsRemoteDataSourceFake.queryResults = NetworkResponse.Success(SearchResultsEntityStub(total = 0))

        val result = repositoryUnderTest.getQueryResults(QUERY)

        assertEquals(emptyList<Int>(), result)
        assertEquals(QUERY, searchResultsRemoteDataSourceFake.calledWithQuery)
    }

    @Test
    fun `getQueryResults() returns null when response is error`() = runTest {
        searchResultsRemoteDataSourceFake.queryResults = NetworkResponse.UnknownError(Throwable())

        val result = repositoryUnderTest.getQueryResults(QUERY)

        assertNull(result)
        assertEquals(QUERY, searchResultsRemoteDataSourceFake.calledWithQuery)
    }
}
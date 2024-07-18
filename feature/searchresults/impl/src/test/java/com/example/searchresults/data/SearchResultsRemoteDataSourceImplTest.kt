package com.example.searchresults.data

import com.example.network.model.NetworkResponse
import com.example.searchresults.testdata.SearchResultsApiFake
import com.example.searchresults.testdata.SearchResultsEntityStub
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class SearchResultsRemoteDataSourceImplTest {
    private val searchResultsApiFake = SearchResultsApiFake()

    private val dataSourceUnderTest = SearchResultsRemoteDataSourceImpl(searchResultsApiFake)

    @Test
    fun `getQueryResults() delegates to api`() = runTest {
        val query = "query"
        val expectedResult = NetworkResponse.Success(SearchResultsEntityStub())
        searchResultsApiFake.queryResults = expectedResult

        val result = dataSourceUnderTest.getQueryResults(query)

        assertEquals(expectedResult, result)
        assertEquals(query, searchResultsApiFake.calledWithQ)
    }
}
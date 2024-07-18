package com.example.searchresults.data

import com.example.network.NetworkResponseAdapterFactory
import com.example.network.model.ErrorResponse
import com.example.network.model.NetworkResponse
import com.example.searchresults.testdata.SearchResultsEntityStub
import com.example.searchresults.testdata.errorJson
import com.example.searchresults.testdata.successJson
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class SearchResultsApiTest {
    private val mockServer = MockWebServer()

    private val apiUnderTest = Retrofit.Builder()
        .baseUrl(mockServer.url("/"))
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
        .build()
        .create(SearchResultsApi::class.java)

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun `getQueryResults() returns success`() = runTest {
        val entity = SearchResultsEntityStub()
        val expectedResponse = NetworkResponse.Success(entity)
        val serverResponse = MockResponse().setBody(successJson)
        mockServer.enqueue(serverResponse)

        val result = apiUnderTest.getQueryResults("query")
        mockServer.takeRequest()

        assertEquals(expectedResponse, result)
    }

    @Test
    fun `getQueryResults() returns error`() = runTest {
        val entity = ErrorResponse("Error")
        val expectedResponse = NetworkResponse.ApiError(entity, 404)
        val serverResponse = MockResponse().setBody(errorJson).setResponseCode(404)
        mockServer.enqueue(serverResponse)

        val result = apiUnderTest.getQueryResults("query")
        mockServer.takeRequest()

        assertEquals(expectedResponse, result)
    }
}
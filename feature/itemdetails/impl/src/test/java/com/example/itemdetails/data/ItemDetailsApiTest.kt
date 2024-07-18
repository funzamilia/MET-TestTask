package com.example.itemdetails.data

import com.example.itemdetails.testdata.ItemDetailsEntityStub
import com.example.itemdetails.testdata.errorJson
import com.example.itemdetails.testdata.successJson
import com.example.network.NetworkResponseAdapterFactory
import com.example.network.model.ErrorResponse
import com.example.network.model.NetworkResponse
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

class ItemDetailsApiTest {
    private val mockServer = MockWebServer()

    private val apiUnderTest = Retrofit.Builder()
        .baseUrl(mockServer.url("/"))
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
        .build()
        .create(ItemDetailsApi::class.java)

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun `getItemDetails() returns success`() = runTest {
        val entity = ItemDetailsEntityStub()
        val expectedResponse = NetworkResponse.Success(entity)
        val serverResponse = MockResponse().setBody(successJson)
        mockServer.enqueue(serverResponse)

        val result = apiUnderTest.getItemDetails("objectId")
        mockServer.takeRequest()

        assertEquals(expectedResponse, result)
    }

    @Test
    fun `getItemDetails() returns error`() = runTest {
        val entity = ErrorResponse("Error")
        val expectedResponse = NetworkResponse.ApiError(entity, 400)
        val serverResponse = MockResponse().setBody(errorJson).setResponseCode(400)
        mockServer.enqueue(serverResponse)

        val result = apiUnderTest.getItemDetails("objectId")
        mockServer.takeRequest()

        assertEquals(expectedResponse, result)
    }
}
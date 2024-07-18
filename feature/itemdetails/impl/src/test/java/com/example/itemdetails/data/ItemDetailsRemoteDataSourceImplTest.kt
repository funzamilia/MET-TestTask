package com.example.itemdetails.data

import com.example.itemdetails.testdata.ItemDetailsApiFake
import com.example.itemdetails.testdata.ItemDetailsEntityStub
import com.example.network.model.NetworkResponse
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ItemDetailsRemoteDataSourceImplTest {
    private val apiFake = ItemDetailsApiFake()

    private val dataSourceUnderTest = ItemDetailsRemoteDataSourceImpl(apiFake)

    @Test
    fun `getItemDetails() delegates to api`() = runTest {
        val objectId = "objectId"
        val expectedResult = NetworkResponse.Success(ItemDetailsEntityStub())
        apiFake.result = expectedResult

        val result = dataSourceUnderTest.getItemDetails(objectId)

        assertEquals(expectedResult, result)
        assertEquals(objectId, apiFake.calledWithObjectId)
    }
}
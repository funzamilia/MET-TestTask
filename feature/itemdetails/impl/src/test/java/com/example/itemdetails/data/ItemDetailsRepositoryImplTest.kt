package com.example.itemdetails.data

import com.example.itemdetails.data.mapper.ItemDetailsEntityToDomainMapper
import com.example.itemdetails.testdata.ItemDetailsEntityStub
import com.example.itemdetails.testdata.ItemDetailsRemoteDataSourceFake
import com.example.itemdetails.testdata.ItemDetailsStub
import com.example.network.model.NetworkResponse
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ItemDetailsRepositoryImplTest {
    private val itemDetailsRemoteDataSourceFake = ItemDetailsRemoteDataSourceFake()
    private val itemDetailsEntityToDomainMapper = ItemDetailsEntityToDomainMapper()

    private val repositoryUnderTest = ItemDetailsRepositoryImpl(
        itemDetailsRemoteDataSourceFake,
        itemDetailsEntityToDomainMapper
    )

    @Test
    fun `getItemDetails() returns item details when available`() = runTest {
        val objectId = "objectId"
        itemDetailsRemoteDataSourceFake.result = NetworkResponse.Success(ItemDetailsEntityStub())

        val result = repositoryUnderTest.getItemDetails(objectId)

        assertEquals(ItemDetailsStub(), result)
        assertEquals(objectId, itemDetailsRemoteDataSourceFake.calledWithObjectId)
    }

    @Test
    fun `getItemDetails() returns null when details unavailable`() = runTest {
        val objectId = "objectId"
        itemDetailsRemoteDataSourceFake.result = NetworkResponse.UnknownError(Throwable())

        val result = repositoryUnderTest.getItemDetails(objectId)

        assertNull(result)
        assertEquals(objectId, itemDetailsRemoteDataSourceFake.calledWithObjectId)
    }
}
package com.example.itemdetails.domain.usecase

import com.example.itemdetails.testdata.ItemDetailsRepositoryFake
import com.example.itemdetails.testdata.ItemDetailsStub
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetItemDetailsUseCaseImplTest {
    private val itemDetailsRepositoryFake = ItemDetailsRepositoryFake()

    private val useCaseUnderTest = GetItemDetailsUseCaseImpl(itemDetailsRepositoryFake)

    @Test
    fun `invoke() delegates to repository`() = runTest {
        val objectId = "objectId"
        val expectedResult = ItemDetailsStub()
        itemDetailsRepositoryFake.result = expectedResult

        val result = useCaseUnderTest(objectId)

        assertEquals(expectedResult, result)
        assertEquals(objectId, itemDetailsRepositoryFake.calledWithObjectId)
    }
}
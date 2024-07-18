package com.example.itemdetails.view

import com.example.itemdetails.testdata.GetItemDetailsUseCaseFake
import com.example.itemdetails.testdata.ItemDetailsStub
import com.example.itemdetails.view.model.ItemDetailsUiState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ItemDetailsViewModelTest {
    private val getItemDetailsUseCaseFake = GetItemDetailsUseCaseFake()

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `init() should add response to uiState when successful`() {
        val itemDetails = ItemDetailsStub()
        getItemDetailsUseCaseFake.result = itemDetails

        val viewModelUnderTest = ItemDetailsViewModel("ID", getItemDetailsUseCaseFake)

        assertEquals(
            ItemDetailsUiState.Content(item = itemDetails),
            viewModelUnderTest.uiState.value,
        )
        assertEquals("ID", getItemDetailsUseCaseFake.calledWithObjectId)
    }

    @Test
    fun `init() should add error to uiState when loading fails`() {
        getItemDetailsUseCaseFake.result = null

        val viewModelUnderTest = ItemDetailsViewModel("ID", getItemDetailsUseCaseFake)

        assertEquals(
            "Item could not be loaded",
            (viewModelUnderTest.uiState.value as? ItemDetailsUiState.Error)?.exception?.message,
        )
    }

    @Test
    fun `init() should add error to uiState when id unavailable`() {
        val viewModelUnderTest = ItemDetailsViewModel(null, getItemDetailsUseCaseFake)

        assertEquals(
            "No item id found",
            (viewModelUnderTest.uiState.value as? ItemDetailsUiState.Error)?.exception?.message,
        )
    }
}
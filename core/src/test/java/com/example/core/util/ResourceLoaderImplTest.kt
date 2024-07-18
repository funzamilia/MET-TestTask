package com.example.core.util

import android.content.Context
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ResourceLoaderImplTest {
    private val contextMock = mockk<Context>()

    private val resourceLoader = ResourceLoaderImpl(contextMock)

    @Test
    fun `getString should return string from context`() {
        val expected = "string"
        every { contextMock.getString(0) } returns expected

        val result = resourceLoader.getString(0)

        assertEquals(expected, result)
    }
}
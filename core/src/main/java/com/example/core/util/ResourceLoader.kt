package com.example.core.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceLoader @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    fun getString(resId: Int): String = context.getString(resId)
}
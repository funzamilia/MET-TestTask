package com.example.core.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

internal class ResourceLoaderImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : ResourceLoader {
    override fun getString(resId: Int) = context.getString(resId)
}
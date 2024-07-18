package com.example.core.util.testdata

import com.example.core.util.ResourceLoader

class ResourceLoaderFake : ResourceLoader {
    var stringToReturn: String? = null
    var fetchedResources = mutableListOf<Int>()
        private set

    override fun getString(resId: Int): String {
        fetchedResources.add(resId)
        return stringToReturn!!
    }
}
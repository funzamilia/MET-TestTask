package com.example.searchresults.testdata

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavDirections

class NavDirectionsFake : NavDirections {
    override val actionId: Int
        get() = 0
    override val arguments: Bundle
        get() = bundleOf()
}
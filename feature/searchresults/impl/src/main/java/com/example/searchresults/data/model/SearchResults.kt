package com.example.searchresults.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchResults(val total: Int, val objectIDs: List<Int>?)
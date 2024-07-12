package com.example.searchresults.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchResultsEntity(val total: Int, val objectIDs: List<Int>?)
package com.example.searchresults.testdata

import com.example.searchresults.data.model.SearchResultsEntity

object SearchResultsEntityStub {
    operator fun invoke(
        total: Int = 3,
        objectIDs: List<Int> = listOf(1, 2, 3)
    ) = SearchResultsEntity(
        total = total,
        objectIDs = objectIDs
    )
}
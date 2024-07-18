package com.example.itemdetails.testdata

import com.example.itemdetails.domain.ItemDetailsRepository
import com.example.itemdetails.domain.model.ItemDetails

class ItemDetailsRepositoryFake : ItemDetailsRepository {
    var result: ItemDetails? = null
    var calledWithObjectId: String? = null
        private set

    override suspend fun getItemDetails(objectId: String): ItemDetails? {
        calledWithObjectId = objectId
        return result
    }
}
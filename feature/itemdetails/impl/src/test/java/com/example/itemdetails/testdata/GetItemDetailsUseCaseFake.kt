package com.example.itemdetails.testdata

import com.example.itemdetails.domain.model.ItemDetails
import com.example.itemdetails.domain.usecase.GetItemDetailsUseCase

class GetItemDetailsUseCaseFake : GetItemDetailsUseCase {
    var result: ItemDetails? = null
    var calledWithObjectId: String? = null
        private set

    override suspend fun invoke(objectId: String): ItemDetails? {
        calledWithObjectId = objectId
        return result
    }
}
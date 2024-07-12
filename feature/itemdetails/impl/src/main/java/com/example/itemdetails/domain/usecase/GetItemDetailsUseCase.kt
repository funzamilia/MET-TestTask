package com.example.itemdetails.domain.usecase

import com.example.itemdetails.domain.ItemDetailsRepository
import javax.inject.Inject

class GetItemDetailsUseCase @Inject constructor(
    private val itemDetailsRepository: ItemDetailsRepository,
) {
    suspend operator fun invoke(objectId: String) = itemDetailsRepository.getItemDetails(objectId)
}
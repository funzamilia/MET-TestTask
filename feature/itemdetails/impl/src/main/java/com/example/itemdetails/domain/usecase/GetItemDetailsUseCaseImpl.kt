package com.example.itemdetails.domain.usecase

import com.example.itemdetails.domain.ItemDetailsRepository
import javax.inject.Inject

class GetItemDetailsUseCaseImpl @Inject constructor(
    private val itemDetailsRepository: ItemDetailsRepository,
) : GetItemDetailsUseCase {
    override suspend operator fun invoke(objectId: String) = itemDetailsRepository.getItemDetails(objectId)
}
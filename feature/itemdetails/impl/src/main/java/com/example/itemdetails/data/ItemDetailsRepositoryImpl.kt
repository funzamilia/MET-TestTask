package com.example.itemdetails.data

import com.example.itemdetails.data.mapper.ItemDetailsEntityToDomainMapper
import com.example.itemdetails.domain.ItemDetailsRepository
import com.example.itemdetails.domain.model.ItemDetails
import javax.inject.Inject

class ItemDetailsRepositoryImpl @Inject constructor(
    private val itemDetailsRemoteDataSource: ItemDetailsRemoteDataSource,
    private val itemDetailsEntityToDomainMapper: ItemDetailsEntityToDomainMapper,
) : ItemDetailsRepository {
    override suspend fun getItemDetails(objectId: String): ItemDetails? {
        val result = itemDetailsRemoteDataSource.getItemDetails(objectId).body()
        return result?.let { itemDetailsEntityToDomainMapper.map(it) }
    }
}
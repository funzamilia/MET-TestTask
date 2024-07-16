package com.example.itemdetails.data

import com.example.itemdetails.data.mapper.ItemDetailsEntityToDomainMapper
import com.example.itemdetails.domain.ItemDetailsRepository
import com.example.itemdetails.domain.model.ItemDetails
import com.example.network.model.NetworkResponse
import javax.inject.Inject

class ItemDetailsRepositoryImpl @Inject constructor(
    private val itemDetailsRemoteDataSource: ItemDetailsRemoteDataSource,
    private val itemDetailsEntityToDomainMapper: ItemDetailsEntityToDomainMapper,
) : ItemDetailsRepository {
    override suspend fun getItemDetails(objectId: String): ItemDetails? {
        return when (val result = itemDetailsRemoteDataSource.getItemDetails(objectId)) {
            is NetworkResponse.Success -> itemDetailsEntityToDomainMapper.map(result.body)
            else -> null
        }
    }
}
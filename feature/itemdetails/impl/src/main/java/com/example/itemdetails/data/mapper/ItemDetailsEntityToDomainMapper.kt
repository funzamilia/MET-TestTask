package com.example.itemdetails.data.mapper

import com.example.itemdetails.data.model.ItemDetailsEntity
import com.example.itemdetails.domain.model.ItemDetails
import javax.inject.Inject

class ItemDetailsEntityToDomainMapper @Inject constructor() {
    fun map(entity: ItemDetailsEntity): ItemDetails {
        return ItemDetails(
            objectID = entity.objectID,
            isHighlight = entity.isHighlight,
            accessionNumber = entity.accessionNumber,
            accessionYear = entity.accessionYear,
            isPublicDomain = entity.isPublicDomain,
            primaryImage = entity.primaryImage,
            primaryImageSmall = entity.primaryImageSmall,
            additionalImages = entity.additionalImages,
            constituents = entity.constituents,
            department = entity.department,
            objectName = entity.objectName,
            title = entity.title,
            culture = entity.culture,
            period = entity.period,
            dynasty = entity.dynasty,
            reign = entity.reign,
            portfolio = entity.portfolio,
            city = entity.city,
            state = entity.state,
            county = entity.county,
            country = entity.country,
            region = entity.region,
            subregion = entity.subregion,
            locale = entity.locale,
        )
    }
}
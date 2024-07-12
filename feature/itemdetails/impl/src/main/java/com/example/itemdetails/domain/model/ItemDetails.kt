package com.example.itemdetails.domain.model

import com.example.itemdetails.data.model.Constituent

data class ItemDetails(
    val objectID: Int,
    val isHighlight: Boolean,
    val accessionNumber: String,
    val accessionYear: String,
    val isPublicDomain: Boolean,
    val primaryImage: String,
    val primaryImageSmall: String,
    val additionalImages: List<String>,
    val constituents: List<Constituent>,
    val department: String,
    val objectName: String,
    val title: String,
    val culture: String,
    val period: String,
    val dynasty: String,
    val reign: String,
    val portfolio: String,
    val city: String,
    val state: String,
    val county: String,
    val country: String,
    val region: String,
    val subregion: String,
    val locale: String,
)
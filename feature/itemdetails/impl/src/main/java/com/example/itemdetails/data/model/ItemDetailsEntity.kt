package com.example.itemdetails.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ItemDetailsEntity(
    val objectID: Int,
    val isHighlight: Boolean,
    val accessionNumber: String,
    val accessionYear: String,
    val isPublicDomain: Boolean,
    val primaryImage: String,
    val primaryImageSmall: String,
    val additionalImages: List<String>,
    val constituents: List<Constituent>?,
    val department: String,
    val objectName: String,
    val title: String,
    val culture: String,
    val period: String,
    val dynasty: String,
    val reign: String,
    val portfolio: String,
    val artistRole: String,
    val artistPrefix: String,
    val artistDisplayName: String,
    val artistDisplayBio: String,
    val artistSuffix: String,
    val artistAlphaSort: String,
    val artistNationality: String,
    val artistBeginDate: String,
    val artistEndDate: String,
    val artistGender: String,
    val artistWikidata_URL: String,
    val artistULAN_URL: String,
    val objectDate: String,
    val objectBeginDate: Int,
    val objectEndDate: Int,
    val medium: String,
    val dimensions: String,
    val measurements: List<Measurement>?,
    val creditLine: String,
    val geographyType: String,
    val city: String,
    val state: String,
    val county: String,
    val country: String,
    val region: String,
    val subregion: String,
    val locale: String,
    val locus: String,
    val excavation: String,
    val river: String,
    val classification: String,
    val rightsAndReproduction: String,
    val linkResource: String,
    val metadataDate: String,
    val repository: String,
    val objectURL: String,
    val tags: List<Tag>?,
    val objectWikidata_URL: String,
    val isTimelineWork: Boolean,
    val GalleryNumber: String
)

@Serializable
data class Constituent(
    val constituentID: Int,
    val role: String,
    val name: String,
    val constituentULAN_URL: String,
    val constituentWikidata_URL: String,
    val gender: String,
)

@Serializable
data class Measurement(
    val elementName: String,
    val elementDescription: String?,
    val elementMeasurements: ElementMeasurements?,
)

@Serializable
data class ElementMeasurements(
    val Height: Double? = null,
    val Length: Double? = null,
    val Width: Double? = null,
    val Thickness: Double? = null,
)

@Serializable
data class Tag(
    val term: String,
    val AAT_URL: String,
    val Wikidata_URL: String,
)
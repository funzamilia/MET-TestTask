package com.example.itemdetails.testdata

import com.example.itemdetails.data.model.Constituent
import com.example.itemdetails.data.model.ItemDetailsEntity
import com.example.itemdetails.data.model.Measurement
import com.example.itemdetails.data.model.Tag

object ItemDetailsEntityStub {
    operator fun invoke(
        objectID: Int = 0,
        isHighlight: Boolean = false,
        accessionNumber: String = "ANO",
        accessionYear: String = "AY",
        isPublicDomain: Boolean = false,
        primaryImage: String = "PI",
        primaryImageSmall: String = "PIS",
        additionalImages: List<String> = emptyList(),
        constituents: List<Constituent> = emptyList(),
        department: String = "D",
        objectName: String = "ON",
        title: String = "T",
        culture: String = "C",
        period: String = "P",
        dynasty: String = "D",
        reign: String = "R",
        portfolio: String = "P",
        artistRole: String = "AR",
        artistPrefix: String = "AP",
        artistDisplayName: String = "ADN",
        artistDisplayBio: String = "ADB",
        artistSuffix: String = "AS",
        artistAlphaSort: String = "AAS",
        artistNationality: String = "AN",
        artistBeginDate: String = "ABD",
        artistEndDate: String = "AED",
        artistGender: String = "AG",
        artistWikidata_URL: String = "AWU",
        artistULAN_URL: String = "AUU",
        objectDate: String = "OD",
        objectBeginDate: Int = 0,
        objectEndDate: Int = 0,
        medium: String = "M",
        dimensions: String = "D",
        measurements: List<Measurement>? = emptyList(),
        creditLine: String = "CL",
        geographyType: String = "GT",
        city: String = "C",
        state: String = "S",
        county: String = "C",
        country: String = "C",
        region: String = "R",
        subregion: String = "SR",
        locale: String = "L",
        locus: String = "L",
        excavation: String = "E",
        river: String = "R",
        classification: String = "C",
        rightsAndReproduction: String = "RAR",
        linkResource: String = "LR",
        metadataDate: String = "MD",
        repository: String = "R",
        objectURL: String = "OU",
        tags: List<Tag> = emptyList(),
        objectWikidata_URL: String = "OWU",
        isTimelineWork: Boolean = false,
        GalleryNumber: String = "GN",
    ) = ItemDetailsEntity(
        objectID = objectID,
        isHighlight = isHighlight,
        accessionNumber = accessionNumber,
        accessionYear = accessionYear,
        isPublicDomain = isPublicDomain,
        primaryImage = primaryImage,
        primaryImageSmall = primaryImageSmall,
        additionalImages = additionalImages,
        constituents = constituents,
        department = department,
        objectName = objectName,
        title = title,
        culture = culture,
        period = period,
        dynasty = dynasty,
        reign = reign,
        portfolio = portfolio,
        artistRole = artistRole,
        artistPrefix = artistPrefix,
        artistDisplayName = artistDisplayName,
        artistDisplayBio = artistDisplayBio,
        artistSuffix = artistSuffix,
        artistAlphaSort = artistAlphaSort,
        artistNationality = artistNationality,
        artistBeginDate = artistBeginDate,
        artistEndDate = artistEndDate,
        artistGender = artistGender,
        artistWikidata_URL = artistWikidata_URL,
        artistULAN_URL = artistULAN_URL,
        objectDate = objectDate,
        objectBeginDate = objectBeginDate,
        objectEndDate = objectEndDate,
        medium = medium,
        dimensions = dimensions,
        measurements = measurements,
        creditLine = creditLine,
        geographyType = geographyType,
        city = city,
        state = state,
        county = county,
        country = country,
        region = region,
        subregion = subregion,
        locale = locale,
        locus = locus,
        excavation = excavation,
        river = river,
        classification = classification,
        rightsAndReproduction = rightsAndReproduction,
        linkResource = linkResource,
        metadataDate = metadataDate,
        repository = repository,
        objectURL = objectURL,
        tags = tags,
        objectWikidata_URL = objectWikidata_URL,
        isTimelineWork = isTimelineWork,
        GalleryNumber = GalleryNumber,
    )
}
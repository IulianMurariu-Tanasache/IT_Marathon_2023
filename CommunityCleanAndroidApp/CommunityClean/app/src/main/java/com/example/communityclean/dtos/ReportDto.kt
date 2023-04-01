package com.example.communityclean.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ReportDto(
    val imageBase64: String,
    val category: Int,
    val comments: String?,
    val contacts: Contacts?,
    val geoTagging: GeoTag,
    val timestamp: String
)

@Serializable
data class Contacts(
    val email: String,
    val tel: String,
    val firstName: String,
    val lastName: String
)

@Serializable
data class GeoTag(
    val latitude: Double,
    val longitude: Double
)

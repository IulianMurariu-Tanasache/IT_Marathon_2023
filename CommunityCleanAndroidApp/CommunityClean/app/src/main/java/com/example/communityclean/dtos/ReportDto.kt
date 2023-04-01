package com.example.communityclean.dtos

data class ReportDto(
    val imageBase64: String,
    val category: Int,
    val comments: String,
    val contacts: Contacts,
    val geoTagging: String,
    val timestamp: String
)

data class Contacts(
    val email: String,
    val tel: String,
    val firstName: String,
    val lastName: String
)

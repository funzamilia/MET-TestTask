package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(val message: String)
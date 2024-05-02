package com.ticketmaster.app.data.dataSources.events.dtos.response

import kotlinx.serialization.Serializable

@Serializable
data class ImageDTO(
    val ratio: String,
    val url: String,
    val width: Int,
    val height: Int,
    val fallback: Boolean
)
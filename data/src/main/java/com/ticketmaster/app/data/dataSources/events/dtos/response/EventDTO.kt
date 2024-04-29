package com.ticketmaster.app.data.dataSources.events.dtos.response

import kotlinx.serialization.Serializable

@Serializable
data class EventDTO(
    val name: String,
    val images: List<ImageDTO>
)
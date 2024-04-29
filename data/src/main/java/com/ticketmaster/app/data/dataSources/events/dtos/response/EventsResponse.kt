package com.ticketmaster.app.data.dataSources.events.dtos.response

import kotlinx.serialization.Serializable

@Serializable
data class EventsResponse(
    val _embedded: EmbeddedDTO
)
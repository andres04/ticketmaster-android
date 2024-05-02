package com.ticketmaster.app.data.dataSources.events.dtos.response

import kotlinx.serialization.Serializable

@Serializable
data class DatesDTO(
    val start: StartDTO
)
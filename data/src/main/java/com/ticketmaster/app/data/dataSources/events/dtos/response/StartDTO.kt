package com.ticketmaster.app.data.dataSources.events.dtos.response

import kotlinx.serialization.Serializable

@Serializable
data class StartDTO(
    val localDate: String,
    val localTime: String?,
)
package com.ticketmaster.app.data.dataSources.events.dtos.response

import kotlinx.serialization.Serializable

@Serializable
data class PriceRangeDTO(
    val type: String,
    val currency: String,
    val min: Double,
    val max: Double
)
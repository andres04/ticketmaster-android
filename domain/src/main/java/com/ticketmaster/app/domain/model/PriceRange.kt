package com.ticketmaster.app.domain.model
data class PriceRange(
    val type: String,
    val currency: String,
    val min: Double,
    val max: Double
)
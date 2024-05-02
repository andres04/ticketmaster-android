package com.ticketmaster.app.domain.model

data class Event(
    val name: String,
    val images: List<Image>,
    val priceRanges: List<PriceRange>,
    val datesStart: DatesStart
)
package com.ticketmaster.app.data.dataSources.events.mappers

import com.ticketmaster.app.data.dataSources.events.dtos.response.PriceRangeDTO
import com.ticketmaster.app.domain.model.PriceRange

fun PriceRangeDTO.toDomain() = PriceRange(
    type = type,
    currency = currency,
    min = min,
    max = max
)
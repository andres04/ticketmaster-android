package com.ticketmaster.app.data.dataSources.events.mappers

import com.ticketmaster.app.data.dataSources.events.dtos.response.DatesDTO
import com.ticketmaster.app.data.dataSources.events.dtos.response.PriceRangeDTO
import com.ticketmaster.app.domain.model.DatesStart
import com.ticketmaster.app.domain.model.PriceRange

fun DatesDTO.toDomain() = DatesStart(
    localDate = start.localDate,
    localTime = start.localTime.orEmpty()
)
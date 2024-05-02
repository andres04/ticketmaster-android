package com.ticketmaster.app.data.dataSources.events.mappers

import com.ticketmaster.app.data.dataSources.events.dtos.response.EventDTO
import com.ticketmaster.app.domain.model.Event

fun EventDTO.toDomain() = Event(
    name = name,
    images = images.map { it.toDomain() },
    priceRanges = priceRanges?.let {  it.map { it.toDomain() } }?: listOf(),
    datesStart = dates.toDomain()
)
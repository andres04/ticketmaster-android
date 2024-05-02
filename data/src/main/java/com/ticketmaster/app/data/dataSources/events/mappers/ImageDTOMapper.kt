package com.ticketmaster.app.data.dataSources.events.mappers

import com.ticketmaster.app.data.dataSources.events.dtos.response.EventDTO
import com.ticketmaster.app.data.dataSources.events.dtos.response.ImageDTO
import com.ticketmaster.app.domain.model.Event
import com.ticketmaster.app.domain.model.Image

fun ImageDTO.toDomain() = Image(
    url = url,
    width = width,
    height = height,
    fallback = fallback,
    ratio = ratio
)
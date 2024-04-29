package com.ticketmaster.app.presentation.events.model

import com.ticketmaster.app.domain.model.Event

fun Event.toModel() = EventModel(
    name = name,
    image = if(images.isNotEmpty()) images[0].url else ""
)
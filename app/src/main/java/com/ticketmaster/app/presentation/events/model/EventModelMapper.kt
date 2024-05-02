package com.ticketmaster.app.presentation.events.model

import com.ticketmaster.app.domain.model.Event

fun Event.toModel() = EventModel(
    name = name,
    image = if(images.isNotEmpty()) images.filter { it.ratio == "3_2"}.minWith(compareByDescending { it.height }).url else "",
    priceMin = if(priceRanges.isNotEmpty()) priceRanges[0].currency+" "+priceRanges[0].min.toString() else "N/A",
    priceMax = if(priceRanges.isNotEmpty()) priceRanges[0].currency+" "+priceRanges[0].min.toString() else "N/A",
    dateStart = datesStart.localDate,
    timeStart = datesStart.localTime
)
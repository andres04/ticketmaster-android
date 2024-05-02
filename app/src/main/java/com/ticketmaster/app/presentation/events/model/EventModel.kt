package com.ticketmaster.app.presentation.events.model

data class EventModel(
    val name: String,
    val image: String,
    val priceMin: String,
    val priceMax: String,
    val dateStart: String,
    val timeStart: String
)
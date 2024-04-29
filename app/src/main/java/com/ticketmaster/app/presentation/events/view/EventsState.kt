package com.ticketmaster.app.presentation.events.view

import com.ticketmaster.app.presentation.events.model.EventModel

sealed class EventsState {

    data object Loading : EventsState()
    data object Empty : EventsState()
    class Success(val events: List<EventModel>) : EventsState()
    class Failure(val message: String) : EventsState()

}
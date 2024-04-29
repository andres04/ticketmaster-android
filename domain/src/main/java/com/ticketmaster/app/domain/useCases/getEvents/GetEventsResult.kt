package com.ticketmaster.app.domain.useCases.getEvents

import com.ticketmaster.app.domain.model.Event
import com.ticketmaster.app.domain.useCases.interfaces.Result

sealed class GetEventsResult : Result {
    class Success(val events: List<Event>) : GetEventsResult()
    class Failure(val message: String, val cause: Exception) : GetEventsResult()
}
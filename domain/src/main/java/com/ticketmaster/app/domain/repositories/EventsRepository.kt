package com.ticketmaster.app.domain.repositories

import com.ticketmaster.app.domain.model.Event
import com.ticketmaster.app.domain.useCases.getEvents.GetEventsResult

interface EventsRepository {
    suspend fun getEvents(): GetEventsResult
}
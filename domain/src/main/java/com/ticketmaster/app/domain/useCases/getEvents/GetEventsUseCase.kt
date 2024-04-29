package com.ticketmaster.app.domain.useCases.getEvents

import com.ticketmaster.app.domain.repositories.EventsRepository
import com.ticketmaster.app.domain.useCases.interfaces.UseCase

class GetEventsUseCase(private val eventsRepository: EventsRepository) : UseCase<GetEventsParams, GetEventsResult>{

    override suspend fun invoke(params: GetEventsParams): GetEventsResult {
        return eventsRepository.getEvents()
    }

}
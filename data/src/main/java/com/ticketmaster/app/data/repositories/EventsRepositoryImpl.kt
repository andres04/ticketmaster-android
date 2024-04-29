package com.ticketmaster.app.data.repositories

import com.ticketmaster.app.data.dataSources.events.impl.NetworkEventsDataSource
import com.ticketmaster.app.data.dataSources.events.mappers.toDomain
import com.ticketmaster.app.data.dataSources.response.DataResponse
import com.ticketmaster.app.domain.model.Event
import com.ticketmaster.app.domain.repositories.EventsRepository
import com.ticketmaster.app.domain.useCases.getEvents.GetEventsResult
import com.ticketmaster.app.domain.useCases.getEvents.GetEventsUseCase

class EventsRepositoryImpl(private val networkEventsDataSource: NetworkEventsDataSource) : EventsRepository{
    override suspend fun getEvents(): GetEventsResult {
        return when(val result = networkEventsDataSource.getEvents()){
            is DataResponse.OnError -> GetEventsResult.Failure(
                cause = Exception(result.error.cause),
                message = result.error.message.orEmpty()
            )
            is DataResponse.OnSuccess -> GetEventsResult.Success(result.data.map { it.toDomain() })
        }
    }
}
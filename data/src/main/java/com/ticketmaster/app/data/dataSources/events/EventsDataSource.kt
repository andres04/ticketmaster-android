package com.ticketmaster.app.data.dataSources.events

import com.ticketmaster.app.data.dataSources.events.dtos.response.EventDTO
import com.ticketmaster.app.data.dataSources.response.DataResponse
import com.ticketmaster.app.domain.model.Event

interface EventsDataSource{

    suspend fun getEvents() : DataResponse<List<EventDTO>>

}
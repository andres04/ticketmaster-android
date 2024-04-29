package com.ticketmaster.app.data.dataSources.events.impl

import com.ticketmaster.app.data.dataSources.events.EventsDataSource
import com.ticketmaster.app.data.dataSources.events.dtos.response.EventDTO
import com.ticketmaster.app.data.dataSources.events.dtos.response.EventsResponse
import com.ticketmaster.app.data.dataSources.response.DataResponse
import com.ticketmaster.app.data.dataSources.response.NetworkError
import com.ticketmaster.app.data.dataSources.response.UnknownError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import java.util.concurrent.TimeoutException

class NetworkEventsDataSource(
    private val httpClient: HttpClient
) : EventsDataSource{

    override suspend fun getEvents(): DataResponse<List<EventDTO>> {
        try {
            val events  = httpClient.get("https://app.ticketmaster.com/discovery/v2/events.json?apikey=DW0E98NrxUIfDDtNN7ijruVSm60ryFLX")
                .body<EventsResponse>()
                ._embedded
                .events
            return DataResponse.OnSuccess(events)
        } catch (e: Exception){
            return DataResponse.OnError(
                when(e){
                    is TimeoutException -> {
                        NetworkError(cause = e)
                    }
                    else -> {
                        UnknownError(cause = e)
                    }
                }
            )
        }
    }
}
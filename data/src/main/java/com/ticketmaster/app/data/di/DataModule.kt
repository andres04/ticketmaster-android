package com.ticketmaster.app.data.di

import com.ticketmaster.app.data.dataSources.events.impl.NetworkEventsDataSource
import com.ticketmaster.app.data.repositories.EventsRepositoryImpl
import com.ticketmaster.app.domain.repositories.EventsRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val dataModule = module {

    single<EventsRepository> {
        EventsRepositoryImpl(
            networkEventsDataSource = get()
        )
    }

    single {
        NetworkEventsDataSource(get())
    }

    single {
        HttpClient(CIO){
            install(ContentNegotiation){
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
                install(Logging) {
                    level = LogLevel.INFO
                }
            }
        }
    }


}
package com.ticketmaster.app.domain.di

import com.ticketmaster.app.domain.useCases.getEvents.GetEventsUseCase
import org.koin.dsl.module

val domainModule = module{

    single {
        GetEventsUseCase(get())
    }

}
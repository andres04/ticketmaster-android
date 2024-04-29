package com.ticketmaster.app.presentation.di

import com.ticketmaster.app.presentation.events.viewModel.EventsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        EventsViewModel(
            eventsUseCase = get()
        )
    }

}
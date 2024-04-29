package com.ticketmaster.app.presentation.events.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ticketmaster.app.domain.useCases.getEvents.GetEventsParams
import com.ticketmaster.app.domain.useCases.getEvents.GetEventsResult
import com.ticketmaster.app.domain.useCases.getEvents.GetEventsUseCase
import com.ticketmaster.app.presentation.events.model.EventModel
import com.ticketmaster.app.presentation.events.model.toModel
import com.ticketmaster.app.presentation.events.view.EventsState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EventsViewModel(private val eventsUseCase: GetEventsUseCase) : ViewModel(){

    private val _eventsState = MutableStateFlow<EventsState>(EventsState.Loading)
    val eventsState  = _eventsState.asStateFlow()

    init {
        getEvents()
    }

    fun getEvents() = viewModelScope.launch(Dispatchers.Main){
        _eventsState.value = EventsState.Loading
        val result = withContext(Dispatchers.IO){ eventsUseCase(GetEventsParams()) }
        _eventsState.value = when(result){
            is GetEventsResult.Failure -> {
                EventsState.Failure(result.message)
            }
            is GetEventsResult.Success -> {
                val events : List<EventModel> = result.events.map { it.toModel() }
                if(events.isEmpty()){
                    EventsState.Empty
                } else {
                    EventsState.Success(events)
                }
            }
        }
    }


}
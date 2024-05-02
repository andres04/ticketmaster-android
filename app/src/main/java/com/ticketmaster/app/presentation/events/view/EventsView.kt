package com.ticketmaster.app.presentation.events.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.ticketmaster.app.presentation.events.viewModel.EventsViewModel
import com.ticketmaster.app.presentation.events.model.EventModel

@Composable
fun EventsView(
    modifier: Modifier,
    viewModel: EventsViewModel
){
    val eventsState by viewModel.eventsState.collectAsStateWithLifecycle()
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        when(val state = eventsState){
            EventsState.Empty -> {
                Text(text = "No events")
            }
            EventsState.Loading -> {
                CircularProgressIndicator()
            }
            is EventsState.Success -> {
                EventsScreen(events = state.events)
            }
            is EventsState.Failure -> {
                Text(text = state.message)
            }
        }
    }

}

@Composable
fun EventsScreen(events: List<EventModel>){
    LazyColumn( modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        events.forEach{ eventModel ->
            item {
                Card {
                    Row(
                        modifier = Modifier.fillMaxWidth().height(150.dp).padding(16.dp)
                    ) {
                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .width(120.dp), contentAlignment = Alignment.BottomCenter){
                            AsyncImage(
                                modifier = Modifier.fillMaxHeight(),
                                model = eventModel.image,
                                contentDescription = null,
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = eventModel.name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Dates start: "+eventModel.dateStart+" "+eventModel.timeStart,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "Prices: "+eventModel.priceMin+" - "+ eventModel.priceMax,
                                fontSize = 14.sp
                            )
                        }


                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}



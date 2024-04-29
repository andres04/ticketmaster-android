package com.ticketmaster.app.data.dataSources.events.dtos.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Embedded")
data class EmbeddedDTO(
     val events : List<EventDTO>
)
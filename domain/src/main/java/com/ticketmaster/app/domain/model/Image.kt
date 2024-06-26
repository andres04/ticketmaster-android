package com.ticketmaster.app.domain.model

data class Image(
    val ratio: String,
    val url: String,
    val width: Int,
    val height: Int,
    val fallback: Boolean
)
package com.ticketmaster.app.domain.useCases.getEvents

import com.ticketmaster.app.data.di.dataModule
import com.ticketmaster.app.domain.di.domainModule
import com.ticketmaster.app.domain.repositories.EventsRepository
import com.ticketmaster.app.presentation.di.presentationModule
import io.mockk.mockk
import io.mockk.verifyAll
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest

class GetEventsUseCaseTest: KoinTest {

    val getEventsUseCase : GetEventsUseCase by inject()

    @Before fun setup() { startKoin() {
        modules(
            domainModule,
            dataModule
        )
    } }
    @After fun teardown() = stopKoin()

    @Test
    fun `list of events returns Success from repository`() = runBlocking{
        val response = getEventsUseCase(GetEventsParams())
        assert(response is GetEventsResult.Success)
    }

    @Test
    fun `list of events is not empty`() = runBlocking{
        val response = getEventsUseCase(GetEventsParams())
        assert(response is GetEventsResult.Success && response.events.isNotEmpty())
    }

}
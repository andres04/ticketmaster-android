package com.ticketmaster.app

import android.app.Application
import com.ticketmaster.app.data.di.dataModule
import com.ticketmaster.app.domain.di.domainModule
import com.ticketmaster.app.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TicketMasterApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@TicketMasterApplication)
            // Load modules
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }

    }
}


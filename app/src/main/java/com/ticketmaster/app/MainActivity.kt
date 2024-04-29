package com.ticketmaster.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ticketmaster.app.domain.useCases.getEvents.GetEventsUseCase
import com.ticketmaster.app.presentation.events.view.EventsView
import com.ticketmaster.app.presentation.events.viewModel.EventsViewModel
import com.ticketmaster.app.ui.theme.TicketMasterTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketMasterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold { padding ->
                        EventsView(
                            modifier = Modifier.padding(padding),
                            viewModel = koinViewModel()
                        )
                    }

                }
            }
        }
    }
}

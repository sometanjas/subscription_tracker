package com.hwr.subscriptiontracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hwr.subscriptiontracker.navigation.AppNavigation
import com.hwr.subscriptiontracker.ui.theme.SubscriptionTrackerTheme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SubscriptionTrackerTheme {
                SubscriptionTrackerApp()
            }
        }
    }
}

@Composable
fun SubscriptionTrackerApp() {
    var showStartScreen by rememberSaveable { mutableStateOf(true) }

    if (showStartScreen) {
        AppNavigation()
    } else {
        var currentDestination by rememberSaveable { mutableStateOf("Home") }

        NavigationSuiteScaffold(
            navigationSuiteItems = {
                item(
                    icon = {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = { Text("Home") },
                    selected = currentDestination == "Home",
                    onClick = { currentDestination = "Home" }
                )
                item(
                    icon = {
                        Icon(
                            Icons.Default.BarChart,
                            contentDescription = "Stats"
                        )
                    },
                    label = { Text("Stats") },
                    selected = currentDestination == "Stats",
                    onClick = { currentDestination = "Stats" }
                )
                item(
                    icon = {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    },
                    label = { Text("Settings") },
                    selected = currentDestination == "Settings",
                    onClick = { currentDestination = "Settings" }
                )
                item(
                    icon = {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Add Service"
                        )
                    },
                    label = { Text("Add Service") },
                    selected = currentDestination == "Add Service",
                    onClick = { currentDestination = "Add Service" }
                )
            }
        ) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Text(
                    text = "Welcome!",
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
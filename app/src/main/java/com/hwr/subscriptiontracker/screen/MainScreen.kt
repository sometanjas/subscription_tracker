package com.hwr.subscriptiontracker.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    onNavigateBack: () -> Unit
) {
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
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Welcome!")

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onNavigateBack,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("BACK")
                }
            }
        }
    }
}
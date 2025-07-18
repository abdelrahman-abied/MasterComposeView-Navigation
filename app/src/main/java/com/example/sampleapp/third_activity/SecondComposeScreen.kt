package com.example.sampleapp.third_activity

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

/**
 * A composable function that displays the second screen of the application.
 *
 * This screen displays a text message and a button to navigate to the previous screen.
 * It also handles the back button press to show a confirmation dialog before exiting.
 *
 */
@Composable
fun SecondComposeScreen(
    modifier: Modifier = Modifier, navController: NavController, text: String? = null
) {
    val shouldShowDialog = remember { mutableStateOf(false) }

    // Handle back button press to show the confirmation dialog
    BackHandler(enabled = true, onBack = {
        shouldShowDialog.value = true
    })
    //
    // Show the confirmation dialog
    if (shouldShowDialog.value) {
        SimpleAlertDialog(
            dialogTitle = "Exit",
            dialogSubTitle = "Are you sure you want to exit?",
            onDismissRequest = { shouldShowDialog.value = false },
        ) {
            navController.popBackStack()
            shouldShowDialog.value = false
        }
    }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "SecondComposeScreen${text}")
        Button(onClick = {
            shouldShowDialog.value = true
        }) {
            Text("Previous Screen")
        }

    }
}

@Preview(name = "SecondComposeScreen")
@Composable
private fun PreviewSecondComposeScreen() {
    // For preview, provide a dummy NavController
    val navController = rememberNavController()
    SecondComposeScreen(navController = navController)
}
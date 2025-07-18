package com.example.sampleapp.first_activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.sampleapp.R
import com.example.sampleapp.ui.theme.SampleAppTheme

@Composable
fun ThirdScreen() {

    // 1. Get the NavController
    val navController = LocalView.current.findNavController()

    SampleAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)
        ) {

            Button(
                modifier = Modifier
                    .align(Alignment.Center),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                content = {
                    Text(
                        text = "Third Step Compose Screen",

                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W700
                        )
                    )
                }, onClick = {
                    // 2. Define the destination and create a Bundle for the arguments
                    val destinationActionId = R.id.action_thirdStepCompose_to_fourthCompose
                    val args = bundleOf(
                        "userName" to "Alex", // A String argument
                        "userId" to 101       // An Int argument
                    )

                    // 3. Navigate, passing both the action ID and the arguments
                    navController.navigate(destinationActionId, args)
                })
        }

    }
}

@Preview
@Composable
fun ThirdScreenPreview() {
    ThirdScreen()
}
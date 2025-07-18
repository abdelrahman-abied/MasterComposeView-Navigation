package com.example.sampleapp.first_activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.findNavController
import com.example.sampleapp.R
import com.example.sampleapp.ui.theme.SampleAppTheme

@Composable
fun ForthScreen() {

    // 1. Get the NavController
    val navController = LocalView.current.findNavController()

    // 2. Access the arguments from the current destination's back stack entry
    val args = navController.currentBackStackEntry?.arguments
    val userName = args?.getString("userName")
    val userId = args?.getInt("userId")

    SampleAppTheme {
        Scaffold() {it ->

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Gray)
                        .padding(it),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Received: User '$userName' with ID: $userId",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.padding(16.dp))
                    Button(
                        modifier = Modifier,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        content = {
                            Text(
                                text = "Forth Step Compose Screen",
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.W700
                                )
                            )
                        }, onClick = {
                            navController.navigate(R.id.action_forthStepCompose_to_fourthFragment)
                        }
                    )
            }
        }
    }
}

@Preview
@Composable
fun ForthScreenPreview() {
    ForthScreen()
}
package com.example.viewmodelguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.viewmodelguide.ui.theme.ViewmodelguideTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<GuideViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewmodelguideTheme {
                Box(
                    Modifier.background(viewModel.backgroundColor)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = viewModel.currentNumber.toString(),
                            fontSize = 60.sp
                        )
                        Button(onClick = {
                            viewModel.addNumber()
                        }) {
                            Text(text = "Add")
                        }
                        Button(onClick = {
                            viewModel.changeBackGroundColor()
                        }) {
                            Text(text = "Change background color")
                        }
                    }
                }
            }
        }
    }
}
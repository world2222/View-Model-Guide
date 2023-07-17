package com.example.viewmodelguide

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import java.util.Random

class GuideViewModel: ViewModel() {
    private val rnd = Random()

    var currentNumber by mutableStateOf(0)
        private set// Prevent being editted in other files or code

    var backgroundColor by mutableStateOf(Color.White)
        private set

    fun addNumber() {
        currentNumber++
    }

    fun changeBackGroundColor() {
        backgroundColor = Color(
            rnd.nextInt(256),
            rnd.nextInt(256),
            rnd.nextInt(256)
        )
    }
}
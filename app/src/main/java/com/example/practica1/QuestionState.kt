package com.example.practica1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Questions(
    val questionsState: MutableList<Question>,
    val totalQuestions: Int = 0
){
    var answerSelected by mutableStateOf(0)
    var questionIndex by mutableStateOf(0)
    var totalScore by mutableStateOf(0)
}
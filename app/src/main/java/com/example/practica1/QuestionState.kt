package com.example.practica1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.Flow

data class Questions(
    val questionsState: List<QuestionWithAnswers> = emptyList(),
    val totalQuestions: Int = 0,
    var question: Flow<QuestionWithAnswers>? = null
){
    var answerSelected by mutableStateOf(0)
    var questionIndex by mutableStateOf(0)
    var totalScore by mutableStateOf(0)
}
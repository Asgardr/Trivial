package com.example.practica1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
/*
class QuizViewModel (
    private val startViewModel: StartViewModel
    ) : ViewModel(){

        //private lateinit var startViewModel : StartViewModel

        private val _state = MutableStateFlow(Questions(mutableListOf<QuestionWithAnswers>()))
        val state: StateFlow<Questions> = _state.asStateFlow()

        fun callTestQuestions()
        {
            viewModelScope.launch{
                TestQuestions()
            }
        }

        suspend fun TestQuestions() {

            //var preguntas = mutableListOf<Question>()

            //Primera Pregunta
            var pregunta = "Esta es la primera pregunta y la respuesta correcta es 2"
            var respuesta1 = Answer(1, "Respuesta 1", 0)
            var respuesta2 = Answer(2, "Respuesta 2", 0)
            var respuesta3 = Answer(3, "Respuesta 3", 0)
            var respuesta4 = Answer(4, "Respuesta 4", 0)
            var respuestaCorrecta = 2
            var question = Question(0, pregunta, respuestaCorrecta)

            startViewModel.addQuestion(question)
            startViewModel.addAnswers(respuesta1, respuesta2, respuesta3, respuesta4)

            //preguntas.add(question)

            //Segunda Pregunta
            pregunta = "Esta es la segunda pregunta y la respuesta correcta es 4"
            respuesta1 = Answer(1, "Respuesta 1", 1)
            respuesta2 = Answer(2, "Respuesta 2", 1)
            respuesta3 = Answer(3, "Respuesta 3", 1)
            respuesta4 = Answer(4, "Respuesta 4", 1)
            //respuestas = listOf(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 4
            //question = Question(0, pregunta, respuesta1,respuesta2,respuesta3, respuesta4, respuestaCorrecta)
            question = Question(1, pregunta, respuestaCorrecta)

            startViewModel.addQuestion(question)
            startViewModel.addAnswers(respuesta1, respuesta2, respuesta3, respuesta4)

            //preguntas.add(question)

            //Tercera Pregunta
            pregunta = "Esta es la tercera pregunta y la respuesta correcta es 1"
            respuesta1 = Answer(1, "Respuesta 1", 2)
            respuesta2 = Answer(2, "Respuesta 2", 2)
            respuesta3 = Answer(3, "Respuesta 3", 2)
            respuesta4 = Answer(4, "Respuesta 4", 2)
            //respuestas = listOf(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 1
            //question = Question(0, pregunta, respuesta1,respuesta2,respuesta3, respuesta4, respuestaCorrecta)
            question = Question(2, pregunta, respuestaCorrecta)

            startViewModel.addQuestion(question)
            startViewModel.addAnswers(respuesta1, respuesta2, respuesta3, respuesta4)

            //preguntas.add(question)

            var testPreguntas = startViewModel.questionList

            _state.update { currentState ->
                currentState.copy(
                    questionsState = testPreguntas,
                    totalQuestions = testPreguntas.size
                )

            }

        }
    }
*/
package com.example.practica1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuizViewModel (
    //private val dao: QuestionDao
    ) : ViewModel(){

        private val _state = MutableStateFlow(Questions(mutableListOf<Question>()))
        val state: StateFlow<Questions> = _state.asStateFlow()

        fun TestQuestions() {

            var preguntas = mutableListOf<Question>()

            //Primera Pregunta
            var pregunta = "Esta es la primera pregunta y la respuesta correcta es 2"
            var respuesta1 = Answer(1, "Respuesta 1")
            var respuesta2 = Answer(2, "Respuesta 2")
            var respuesta3 = Answer(3, "Respuesta 3")
            var respuesta4 = Answer(4, "Respuesta 4")
            var respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            var respuestaCorrecta = 2
            var question = Question(pregunta, respuestas, respuestaCorrecta)

            preguntas.add(question)

            //Segunda Pregunta
            pregunta = "Esta es la segunda pregunta y la respuesta correcta es 4"
            respuesta1 = Answer(1, "Respuesta 1")
            respuesta2 = Answer(2, "Respuesta 2")
            respuesta3 = Answer(3, "Respuesta 3")
            respuesta4 = Answer(4, "Respuesta 4")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 4
            question = Question(pregunta, respuestas, respuestaCorrecta)

            preguntas.add(question)

            //Tercera Pregunta
            pregunta = "Esta es la tercera pregunta y la respuesta correcta es 1"
            respuesta1 = Answer(1, "Respuesta 1")
            respuesta2 = Answer(2, "Respuesta 2")
            respuesta3 = Answer(3, "Respuesta 3")
            respuesta4 = Answer(4, "Respuesta 4")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 1
            question = Question(pregunta, respuestas, respuestaCorrecta)

            preguntas.add(question)

            _state.update { currentState ->
                currentState.copy(
                    questionsState = preguntas,
                    totalQuestions = preguntas.size
                )

            }

        }
    }

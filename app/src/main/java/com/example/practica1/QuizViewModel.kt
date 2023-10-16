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
            var pregunta = "¿Cuál fue la primera tarjeta gráfica que implementó la arquitectura unificada?"
            var respuesta1 = Answer(1, "NVIDIA G90")
            var respuesta2 = Answer(2, "ATI Xenox")
            var respuesta3 = Answer(3, "NVIDIA G80")
            var respuesta4 = Answer(4, "AMD R500")
            var respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            var respuestaCorrecta = 2
            var question = Question(pregunta, respuestas, respuestaCorrecta)

            preguntas.add(question)

            //Segunda Pregunta
            pregunta = "¿En qué se diferencian las tarjetas gráficas de la misma familia pero distinta gama?"
            respuesta1 = Answer(1, "En la velocidad de los CUDA Cores")
            respuesta2 = Answer(2, "En la potencia de los Stream Multiprocessor")
            respuesta3 = Answer(3, "En la cantidad de CUDA Cores por Stream Multiprocessor")
            respuesta4 = Answer(4, "En el número de Stream Multiprocessors")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 4
            question = Question(pregunta, respuestas, respuestaCorrecta)

            preguntas.add(question)

            //Tercera Pregunta
            pregunta = "¿Para qué se crearon las primeras Tarjetas Gráficas?"
            respuesta1 = Answer(1, "Para acelerar el Quake")
            respuesta2 = Answer(2, "Para la facilitar computación de la NASA")
            respuesta3 = Answer(3, "Para el aumentar la fluidez del intercambio de datos en Wall Street")
            respuesta4 = Answer(4, "Para renderizar los primeros proyectos de animación digital")
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

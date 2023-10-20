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
            var pregunta = "¿Cuál es el juego de esta imagen?"
            var respuesta1 = Answer(1, "Persona 5")
            var respuesta2 = Answer(2, "Fire emblem")
            var respuesta3 = Answer(3, "The Caligula Effect: Overdose")
            var respuesta4 = Answer(4, "Persona 4")
            var respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            var respuestaCorrecta = 1
            var imagen = "Persona 5";
            var question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            //Segunda Pregunta
            pregunta = "¿Cuál es el juego de esta imagen?"
            respuesta1 = Answer(1, "Harvest Moon")
            respuesta2 = Answer(2, "Animal crossing")
            respuesta3 = Answer(3, "Fantasy Life")
            respuesta4 = Answer(4, "My Time at Portia")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 2
            imagen = "Animal Crossing"
            question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            //Tercera Pregunta
            pregunta = "¿Cuál es el juego de esta imagen?"
            respuesta1 = Answer(1, "yokai watch")
            respuesta2 = Answer(2, "digimon")
            respuesta3 = Answer(3, "Pokémon sol y luna")
            respuesta4 = Answer(4, "Monster sanctuary")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 3
            imagen = "Pokemon sol y luna"
            question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            //Cuarta Pregunta
            pregunta = "¿Cuál es el juego de esta imagen?"
            respuesta1 = Answer(1, "Overwatch")
            respuesta2 = Answer(2, "CSGO")
            respuesta3 = Answer(3, "Valorant")
            respuesta4 = Answer(4, "Rainbow Six Siege")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 3
            imagen = "Valorant"
            question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            //Quinta Pregunta
            pregunta = "¿Cuál es el juego de esta imagen?"
            respuesta1 = Answer(1, "Resident Evil 7")
            respuesta2 = Answer(2, "Outlast")
            respuesta3 = Answer(3, "Amnesia")
            respuesta4 = Answer(4, "Alien Isolation")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 2
            imagen = "Outlast"
            question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            //Sexta Pregunta
            pregunta = "¿Que personaje de videojuego es este?"
            respuesta1 = Answer(1, "Alien (Space Invaders)")
            respuesta2 = Answer(2, "Fantasma (Pacman)")
            respuesta3 = Answer(3, "Sans (Undertale)")
            respuesta4 = Answer(4, "T-Rex (Dino run)")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 4
            imagen = "T-Rex (Dino Run)"
            question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            //Séptima Pregunta
            pregunta = "¿Que personaje de videojuego es este?"
            respuesta1 = Answer(1, "Roadhog (overwatch)")
            respuesta2 = Answer(2, "Heavy (team fortress 2)")
            respuesta3 = Answer(3, "Dr. zed (borderlands)")
            respuesta4 = Answer(4, "Cole (Gears of war)")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 2
            imagen = "Heavy (team fortress 2)"
            question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            //Octava Pregunta
            pregunta = "¿Que personaje de videojuego es este?"
            respuesta1 = Answer(1, "Red(pokemon)")
            respuesta2 = Answer(2, "Silver(pokemon)")
            respuesta3 = Answer(3, "Barry(pokemon)")
            respuesta4 = Answer(4, "Blue(pokemon)")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 4
            imagen = "Blue(pokemon)"
            question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            //Novena Pregunta
            pregunta = "¿Que personaje de videojuego es este?"
            respuesta1 = Answer(1, "The Knight (Hollow Knight)")
            respuesta2 = Answer(2, "Lamb (Cult of the Lamb)")
            respuesta3 = Answer(3, "Isaac (The Binding of Isaac)")
            respuesta4 = Answer(4, "Cuphead (Cuphead)")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 1
            imagen = 1
            question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            //Décima Pregunta
            pregunta = "¿Que personaje de videojuego es este?"
            respuesta1 = Answer(1, "Kratos(god of war)")
            respuesta2 = Answer(2, "Jhonny Silverhand (Cyberpunk 2077)")
            respuesta3 = Answer(3, "Joel (the last of us)")
            respuesta4 = Answer(4, "Astarion (Baldurs Gate 3)")
            respuestas = listOf<Answer>(respuesta1, respuesta2, respuesta3, respuesta4)
            respuestaCorrecta = 4
            imagen =
            question = Question(pregunta, respuestas, respuestaCorrecta, imagen)

            preguntas.add(question)

            _state.update { currentState ->
                currentState.copy(
                    questionsState = preguntas,
                    totalQuestions = preguntas.size
                )

            }

        }
    }

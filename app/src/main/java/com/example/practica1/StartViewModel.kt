package com.example.practica1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practica1.db.questions.QuestionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class StartViewModel (private val questionRepository: QuestionRepository): ViewModel(){

    private var questionList: Flow<List<QuestionWithAnswers>> = questionRepository.allQuestions
    private lateinit var questionWithAnswers: Flow<QuestionWithAnswers>
    //val foundQuestion: LiveData<Question> = questionRepository.foundQuestion

    private val _state = MutableStateFlow(Questions())
    val state: StateFlow<Questions> = _state.asStateFlow()

    fun getAllQuestions()
    {
        questionRepository
    }

    fun getQuestionWithAnswerById(questionId: Int)
    {
        viewModelScope.launch {
            questionWithAnswers = questionRepository.questionWithAnswers(questionId)
        }
    }

    suspend fun addQuestion(question: Question)
    {
        questionRepository.addQuestion(question)

    }

    suspend fun addAnswers(answer1: Answer, answer2: Answer, answer3: Answer, answer4: Answer)
    {
        questionRepository.addAnswer(answer1)
        questionRepository.addAnswer(answer2)
        questionRepository.addAnswer(answer3)
        questionRepository.addAnswer(answer4)
    }

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

        addQuestion(question)
        addAnswers(respuesta1, respuesta2, respuesta3, respuesta4)

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

        addQuestion(question)
        addAnswers(respuesta1, respuesta2, respuesta3, respuesta4)

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

        addQuestion(question)
        addAnswers(respuesta1, respuesta2, respuesta3, respuesta4)

        //preguntas.add(question)

        val testPreguntas = questionList

        Log.d("Lista de Preguntas", "HOLA")

        Log.d("MyActivity", "${questionList}")

        _state.update { currentState ->
            currentState.copy(
                totalQuestions = testPreguntas.toList().size,
            )
        }

    }

    suspend fun CambiarPregunta(preguntaId: Int)
    {
        getQuestionWithAnswerById(preguntaId)
        _state.update { it.copy(
            question = questionWithAnswers
        ) }
    }
}

class StartViewModelFactory(private val repository: QuestionRepository): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StartViewModel::class.java))
            return StartViewModel(repository) as T

        throw IllegalArgumentException ("Clase desconocida para el View Model")
    }
}
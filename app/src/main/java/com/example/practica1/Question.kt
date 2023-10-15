package com.example.practica1

//import androidx.room.Entity
//import androidx.room.PrimaryKey

//@Entity
data class Question(
    val question: String,
    val answers: List<Answer>,
    val correctAnswer: Int,
    //@PrimaryKey(autoGenerate = true)
    //val id: Int? = null,
)

data class Answer(
    val id: Int,
    val text: String
)
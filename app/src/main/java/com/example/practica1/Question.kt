package com.example.practica1

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "tabla_preguntas")
data class Question(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "pregunta")
    val question: String,

    @ColumnInfo(name = "respuestaCorrecta")
    val correctAnswer: Int,
)

@Entity(
    tableName = "tabla_respuestas",
    /*foreignKeys = [
        ForeignKey(
            entity = Question::class,
            parentColumns = ["id"],
            childColumns = ["questionId"],
            onDelete = ForeignKey.CASCADE
        )
    ]*/)
data class Answer(
    @ColumnInfo(name = "answerId")
    val answerId: Int?,

    @ColumnInfo (name = "respuesta")
    val text: String,

    @ColumnInfo (name = "questionId")
    val questionId: Int?,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

data class QuestionWithAnswers (
    @Embedded
    val question: Question,
    @Relation(
        entity = Answer::class,
        parentColumn = "id",
        entityColumn = "questionId",
    )
    val answer: List<Answer>
)
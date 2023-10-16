package com.example.practica1

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practica1.ui.theme.Practica1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quiz(
    navController: NavHostController,
    questions: Questions,
    stopwatch: Stopwatch
){
    stopwatch.start()

    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Scaffold(
            topBar = {
                QuizTopBar(
                    questions = questions,
                    stopwatch = stopwatch)
            },
            content = { padding ->
                QuizContent(
                    question = questions.questionsState[questions.questionIndex],
                    selectedAnswer = questions.answerSelected,
                    onAnswer = {
                        questions.answerSelected = it.id
                        if(questions.answerSelected == questions.questionsState[questions.questionIndex].correctAnswer){
                            println("La Respuesta es correcta")
                            questions.totalScore++
                        }else{
                            println("La Respuesta es incorrecta")
                        }
                        //Thread.sleep(1000)
                        if((questions.questionIndex + 1) < questions.totalQuestions ){
                            questions.questionIndex++
                        }else{
                            stopwatch.pause()
                            navController.navigate("score/${questions.totalScore}")
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding))
            }
        )
    }
}


@Composable
private fun QuizTopBar(
    questions: Questions,
    stopwatch: Stopwatch
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.fillMaxWidth()){
            var modifier = Modifier
                .padding(vertical = 20.dp)
                .align(Alignment.Center)

            val text = buildAnnotatedString {
                append("${questions.questionIndex + 1} ")
                append("of ${questions.totalQuestions}")
            }

            Text(
                text = text,
                modifier = modifier
            )
        }

        val animatedProgress by animateFloatAsState(
            targetValue = (questions.questionIndex + 1) / questions.totalQuestions.toFloat(),
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec)

        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            trackColor = Color.White.copy(alpha = 0.24f)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stopwatch.formattedTime)
        }
    }
}

@Composable
private fun QuizContent(
    question: Question,
    selectedAnswer: Int,
    onAnswer: (Answer) -> Unit,
    modifier: Modifier = Modifier
){
    val onSurface = Color(0xFF1C1B1F)


    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Image( painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "ImagenPrueba",
                modifier = Modifier.padding(horizontal = 130.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = onSurface.copy(alpha = 0.04f)
                    )
            ) {
                Text(
                    text = question.question,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp, horizontal = 16.dp)
                )


            }
            Spacer(modifier = Modifier.height(24.dp))

            AnswerOptions(
                question = question,
                selectedAnswer = selectedAnswer,
                onAnswerSelected = { answer ->  onAnswer(answer)},
                modifier = Modifier.fillParentMaxWidth())
        }
    }
}

@Composable
private fun AnswerOptions(
    question: Question,
    selectedAnswer: Int,
    onAnswerSelected: (Answer) -> Unit,
    modifier: Modifier = Modifier
){
    val options = question.answers

    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(selectedAnswer)
    }

    Column(modifier = modifier) {
        options.forEach { answer ->
            val onClickHandle = {
                onOptionSelected(answer.id)
                onAnswerSelected(answer)
            }

            val optionSelected = answer.id == selectedOption

            val answerBorderColor = if (optionSelected) {
                if (selectedOption == question.correctAnswer) {
                    colorScheme.primaryContainer.copy(alpha = 0.5f)
                } else {
                    colorScheme.secondaryContainer.copy(alpha = 0.5f)
                }
            }else{
                colorScheme.secondary.copy(alpha = 0.12f)
            }

            val answerBackgroundColor = if (optionSelected) {
                if (selectedOption == question.correctAnswer) {
                    colorScheme.primaryContainer.copy(alpha = 0.5f)
                } else {
                    colorScheme.secondaryContainer.copy(alpha = 0.5f)
                }
            }else{
                colorScheme.secondary.copy(alpha = 0.12f)
            }

            Surface(
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(
                    width = 1.dp,
                    color = answerBorderColor
                ),
                modifier = modifier.padding(vertical = 8.dp)
            ){
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = optionSelected,
                            onClick = onClickHandle
                        )
                        .background(answerBackgroundColor)
                        .padding(vertical = 16.dp, horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        modifier = modifier.weight(1f),
                        text = answer.text
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun QuizPrewiew(){
    Practica1Theme() {
        //Quiz(questionIndex = 2, totalQuestionsCount = 5)
    }
}

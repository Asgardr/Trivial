package com.example.practica1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.practica1.ui.theme.Practica1Theme
import kotlin.time.ExperimentalTime

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<QuizViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica1Theme {

                val navController = rememberNavController()
                val stopwatch = Stopwatch()
                NavHost(navController = navController, startDestination = "start"){
                    composable(route = "start"){
                        Start(navController = navController)
                    }
                    composable("quiz"){
                        viewModel.TestQuestions()

                        val questionsState by viewModel.state.collectAsState()

                        Quiz(
                            navController = navController,
                            questions = questionsState,
                            stopwatch = stopwatch)
                    }
                    composable("score/{score}"){ backStackEntry ->
                        val score = backStackEntry.arguments?.getString("score")
                        Score(
                            navController = navController,
                            score = score,
                            stopwatch = stopwatch
                        )
                    }
                }
            }
        }
    }
}
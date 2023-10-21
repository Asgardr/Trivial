package com.example.practica1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.rememberNavController
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.practica1.ui.theme.Practica1Theme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.ExperimentalTime

class MainActivity : ComponentActivity() {

    private val startViewModel by viewModels<StartViewModel>{
        StartViewModelFactory((application as TrivialApplication).repository)
    }
    //private val viewModel by viewModels<QuizViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica1Theme {

                val navController = rememberNavController()
                val stopwatch = Stopwatch()
                NavHost(navController = navController, startDestination = "start"){
                    composable(route = "start"){
                        startViewModel.callTestQuestions()

                        Start(navController = navController)
                    }
                    composable("quiz"){

                        val questionsState by startViewModel.state.collectAsState()

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
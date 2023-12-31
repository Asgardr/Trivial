package com.example.practica1

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.String.format
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Timer
import kotlin.concurrent.fixedRateTimer
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

class Stopwatch {

    var formattedTime by mutableStateOf("00:00")

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatter = DateTimeFormatter.ofPattern("mm:ss")

    private var pattern = "mm:ss"
    private var simpleDateFormat = SimpleDateFormat(pattern)

    private var coroutine = CoroutineScope(Dispatchers.Main)
    private var time = 0L
    private var startTime = 0L

    var isPlaying = false
    var isPaused = false


    fun start(){

        Log.d("Start", "$isPlaying")

        //if(isPlaying) return

        coroutine.launch {
            startTime = System.currentTimeMillis()
            isPlaying = true
            Log.d("Corrutina", "$isPlaying")
            while(isPlaying && !isPaused){
                delay(10L)
                time += System.currentTimeMillis() - startTime
                startTime = System.currentTimeMillis()
                formattedTime = simpleDateFormat.format(Date(time))
            }
        }
    }

    fun reset(){
        time = 0L
        startTime = 0L
        isPaused = false
    }


    fun pause(){
        isPaused = true
        Log.d("Pause", "$isPlaying")
    }

    fun stop(){
        pause()
    }
}


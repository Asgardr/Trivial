package com.example.practica1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Start(
    navController: NavHostController,
    questionState : Questions,
    stopwatch : Stopwatch
){
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Title()
            StartButton(
                onStart = {
                    stopwatch.reset()
                    stopwatch.start()
                    questionState.questionIndex = 0
                    navController.navigate("quiz")
                }
            )
        }
    }
}

@Composable
private fun StartButton(
    onStart: () -> Unit
){
    OutlinedButton(onClick = onStart) {
        Text(text = "Start")
    }
}
@Composable
private fun Title(){
    Column(
        Modifier.padding(50.dp)
    ) {
        Text(text = "El Gran Quiz de Videojuegos",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }

}

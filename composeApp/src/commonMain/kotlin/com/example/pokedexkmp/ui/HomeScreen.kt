package com.example.pokedexkmp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen (
    onSeePokedexclick: () -> Unit,
    onSeeTeamClick: () -> Unit

){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding ( all = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Text (
        text = "Pokedex KMP",
                style = MaterialTheme.typography.headlineLarge
    )
        Text (
            text = "Exemplo de navegação, grid, utilização de imagens e objetos",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding()
        )

        Button(onClick = onSeePokedexclick) {
            Text( "Ver pokedex")
        }

        Button(onClick = onSeeTeamClick) {
            Text( "Ver Meu Time")
        }

}
    }

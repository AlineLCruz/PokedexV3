package com.example.pokedexkmp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedexkmp.data.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun TeamScreen(
    team: List<Pokemon>,
    onBackClick: () -> Unit,
    onRemovePokemon: (Pokemon) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meu Time (iOS)") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) {\n        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Implementação com estética Apple (Human Interface Guidelines) aqui
            if (team.isEmpty()) {
                Text("Seu time está vazio.")
            } else {
                LazyColumn {
                    items(team) {
                        pokemon ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(pokemon.name.capitalizePokemonName(), style = MaterialTheme.typography.headlineSmall)
                                Text("ID: ${pokemon.id}")
                                Text("Tipos: ${pokemon.types.joinToString { it.capitalizePokemonName() }}")
                                Button(onClick = { onRemovePokemon(pokemon) }) {
                                    Text("Remover")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

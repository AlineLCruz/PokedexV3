package com.example.pokedexkmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pokedexkmp.data.PokemonRepositoryImpl
import com.example.pokedexkmp.navigation.HomeRoute
import com.example.pokedexkmp.navigation.PokedexRoute
import com.example.pokedexkmp.navigation.PokemonDetailRoute
import com.example.pokedexkmp.navigation.TeamRoute
import com.example.pokedexkmp.ui.HomeScreen
import com.example.pokedexkmp.ui.PokedexGridScreen
import com.example.pokedexkmp.ui.PokemonDetailScreen
import com.example.pokedexkmp.ui.TeamScreen
import com.example.pokedexkmp.viewmodel.TeamViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        val pokemonRepository = remember { PokemonRepositoryImpl() }
        val teamViewModel: TeamViewModel = viewModel()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(currentRoute?.let { route ->
                        when (route) {
                            HomeRoute.toString() -> "Pokedex KMP"
                            PokedexRoute.toString() -> "Pokédex"
                            TeamRoute.toString() -> "Meu Time"
                            else -> "Detalhes do Pokémon"
                        }
                    } ?: "Pokedex KMP") }
                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        selected = currentRoute == HomeRoute.toString(),
                        onClick = { navController.navigate(HomeRoute) }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.List, contentDescription = "Pokédex") },
                        label = { Text("Pokédex") },
                        selected = currentRoute == PokedexRoute.toString(),
                        onClick = { navController.navigate(PokedexRoute) }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Star, contentDescription = "Meu Time") },
                        label = { Text("Meu Time") },
                        selected = currentRoute == TeamRoute.toString(),
                        onClick = { navController.navigate(TeamRoute) }
                    )
                }
            }
        ) {\n            paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = HomeRoute
                ){

                    composable<HomeRoute> {
                        HomeScreen (
                            onSeePokedexclick = {
                                navController.navigate(PokedexRoute)
                            },
                            onSeeTeamClick = {
                                navController.navigate(TeamRoute)
                            }
                        )

                    }
                    composable<PokedexRoute> {
                        PokedexGridScreen(
                            pokemons = pokemonRepository.getPokemonList(),
                            onPokemonClick = { pokemonId ->
                                navController.navigate(PokemonDetailRoute(pokemonId))
                            },
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }


                    composable<PokemonDetailRoute> { backStackEntry ->
                        val route = backStackEntry.toRoute<PokemonDetailRoute>()
                        val pokemon = pokemonRepository.getPokemonById(route.pokemonId)

                        PokemonDetailScreen(
                            pokemon = pokemon,
                            onBackClick = {
                                navController.popBackStack()
                            },
                            onAddToTeamClick = {
                                pokemon?.let { teamViewModel.addPokemonToTeam(it) }
                            }
                        )
                    }

                    composable<TeamRoute> {
                        TeamScreen(
                            team = teamViewModel.team,
                            onBackClick = {
                                navController.popBackStack()
                            },
                            onRemovePokemon = {
                                teamViewModel.removePokemonFromTeam(it)
                            }
                        )
                    }
                }
            }
        }
    }
}

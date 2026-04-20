package com.example.pokedexkmp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pokedexkmp.data.Pokemon

class TeamViewModel : ViewModel() {
    private val _team = mutableStateListOf<Pokemon>()
    val team: List<Pokemon> get() = _team

    fun addPokemonToTeam(pokemon: Pokemon) {
        if (!_team.contains(pokemon)) {
            _team.add(pokemon)
        }
    }

    fun removePokemonFromTeam(pokemon: Pokemon) {
        _team.remove(pokemon)
    }
}

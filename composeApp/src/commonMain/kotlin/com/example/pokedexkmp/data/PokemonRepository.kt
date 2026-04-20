package com.example.pokedexkmp.data

interface PokemonRepository {
    fun getPokemonList(): List<Pokemon>
    fun getPokemonById(id: Int): Pokemon?
}

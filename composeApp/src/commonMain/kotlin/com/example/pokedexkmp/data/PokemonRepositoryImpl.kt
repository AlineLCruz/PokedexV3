package com.example.pokedexkmp.data

class PokemonRepositoryImpl : PokemonRepository {
    override fun getPokemonList(): List<Pokemon> {
        return PokemonMock.getPokemonList()
    }

    override fun getPokemonById(id: Int): Pokemon? {
        return PokemonMock.getPokemonById(id)
    }
}

package com.example.pokedexkmp.data

object PokemonMock {

    val pokedex = listOf(
        Pokemon(
            id = 1,
            name = "bulbasaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            types = listOf("grass", "poison"),
            height = 7,
            weight = 69,
            stats = listOf(
                PokemonStat("hp", 45),
                PokemonStat("attack", 49),
                PokemonStat("defense", 49),
                PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 65),
                PokemonStat("speed", 45)
            ),
            description = "Bulbasaur carrega uma semente em suas costas desde o nascimento."
        ),
        Pokemon(
            id = 4,
            name = "charmander",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
            types = listOf("fire"),
            height = 6,
            weight = 85,
            stats = listOf(
                PokemonStat("hp", 39),
                PokemonStat("attack", 52),
                PokemonStat("defense", 43),
                PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 50),
                PokemonStat("speed", 65)
            ),
            description = "Charmander possui uma chama na ponta da cauda que indica sua vitalidade."
        ),
        Pokemon(
            id = 7,
            name = "squirtle",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
            types = listOf("water"),
            height = 5,
            weight = 90,
            stats = listOf(
                PokemonStat("hp", 44),
                PokemonStat("attack", 48),
                PokemonStat("defense", 65),
                PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 64),
                PokemonStat("speed", 43)
            ),
            description = "Squirtle se protege com seu casco e lança jatos d’água."
        ),
        Pokemon(
            id = 25,
            name = "pikachu",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
            types = listOf("electric"),
            height = 4,
            weight = 60,
            stats = listOf(
                PokemonStat("hp", 35),
                PokemonStat("attack", 55),
                PokemonStat("defense", 40),
                PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 50),
                PokemonStat("speed", 90)
            ),
            description = "Pikachu armazena eletricidade em suas bochechas."
        ),
        Pokemon(
            id = 39,
            name = "jigglypuff",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png",
            types = listOf("normal", "fairy"),
            height = 5,
            weight = 55,
            stats = listOf(
                PokemonStat("hp", 115),
                PokemonStat("attack", 45),
                PokemonStat("defense", 20),
                PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 25),
                PokemonStat("speed", 20)
            ),
            description = "Jigglypuff encanta adversários com sua canção."
        ),
        Pokemon(
            id = 133,
            name = "eevee",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/133.png",
            types = listOf("normal"),
            height = 3,
            weight = 65,
            stats = listOf(
                PokemonStat("hp", 55),
                PokemonStat("attack", 55),
                PokemonStat("defense", 50),
                PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 65),
                PokemonStat("speed", 55)
            ),
            description = "Eevee possui uma estrutura genética instável e várias evoluções possíveis."
        ),
        Pokemon(
            id = 77,
            name = "ponyta",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/77.png",
            types = listOf("fire"),
            height = 10,
            weight = 300,
            stats = listOf(
                PokemonStat("hp", 50),
                PokemonStat("attack", 85),
                PokemonStat("defense", 55),
                PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 65),
                PokemonStat("speed", 90)
            ),
            description = "Ponyta é conhecido por sua crina flamejante e sua velocidade."
        ),
        Pokemon(
            id = 152,
            name = "chikorita",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/152.png",
            types = listOf("grass"),
            height = 9,
            weight = 64,
            stats = listOf(
                PokemonStat("hp", 45),
                PokemonStat("attack", 49),
                PokemonStat("defense", 65),
                PokemonStat("special-attack", 49),
                PokemonStat("special-defense", 65),
                PokemonStat("speed", 45)
            ),
            description = "Chikorita libera um aroma doce de sua folha para acalmar os outros."
        ),
        Pokemon(
            id = 155,
            name = "cyndaquil",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/155.png",
            types = listOf("fire"),
            height = 5,
            weight = 79,
            stats = listOf(
                PokemonStat("hp", 39),
                PokemonStat("attack", 52),
                PokemonStat("defense", 43),
                PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 50),
                PokemonStat("speed", 65)
            ),
            description = "Cyndaquil tem chamas nas costas que acendem quando está irritado ou atacando."
        ),
        Pokemon(
            id = 158,
            name = "totodile",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/158.png",
            types = listOf("water"),
            height = 6,
            weight = 95,
            stats = listOf(
                PokemonStat("hp", 50),
                PokemonStat("attack", 65),
                PokemonStat("defense", 64),
                PokemonStat("special-attack", 44),
                PokemonStat("special-defense", 48),
                PokemonStat("speed", 43)
            ),
            description = "Totodile é um Pokémon brincalhão com uma mordida poderosa."
        )
    )

    fun getPokemonList(): List<Pokemon> {
        return pokedex
    }

    fun getPokemonById(id: Int): Pokemon? {
        return pokedex.find { it.id == id }
    }
}

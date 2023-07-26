package com.roger.teste1.services.pokemon;

import java.util.List;

import com.roger.teste1.model.PokemonModel;

public interface PokemonService {
    
    List<PokemonModel> findAll();

    PokemonModel save(PokemonModel pokemonModel);

    PokemonModel findById(Integer id );

    PokemonModel update(PokemonModel atualizacaoPokemon);

    String deleteById(Integer id);

}

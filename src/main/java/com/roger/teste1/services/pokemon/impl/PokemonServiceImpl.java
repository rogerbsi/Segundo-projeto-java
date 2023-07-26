package com.roger.teste1.services.pokemon.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roger.teste1.model.PokemonModel;
import com.roger.teste1.repository.PokemonRepository;
import com.roger.teste1.services.pokemon.PokemonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    @Override
    public List<PokemonModel> findAll() {

        return pokemonRepository.findAll();

    }

    @Override
    public PokemonModel save(PokemonModel pokemonModel) {
        pokemonModel.setVida(pokemonModel.getVida() * 2);
        return pokemonRepository.save(pokemonModel);
    }

    @Override
    public PokemonModel findById(Integer id) {

        return pokemonRepository.findById(id).orElse(null);
    }

    @Override
    public PokemonModel update(PokemonModel atualizacao) {
        if (atualizacao.getId() == null) {
            return null;
        }
        return pokemonRepository.save(atualizacao);
    }

    @Override
    public String deleteById(Integer id) {
        if (pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);
            return "Deletado com sucesso!";
        }
        return "Não deletado com sucesso! Certo?";
    }

    // aqui implementa as rotinas
}

package com.roger.teste1.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.roger.teste1.model.PokemonModel;

public interface PokemonRepository extends CrudRepository<PokemonModel, Integer> {

    List<PokemonModel> findByNomeContainsIgnoreCase(String nome);

    List<PokemonModel> findAll();
}

package com.roger.teste1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.roger.teste1.model.PokemonModel;
import com.roger.teste1.services.pokemon.PokemonService;

import lombok.RequiredArgsConstructor;

/**
 * PokemonController
 */
@RestController
@RequestMapping(value = "/pokemon")

@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    public List<PokemonModel> findAll() {
        return pokemonService.findAll();
    }

    @PostMapping
    public String save(PokemonModel recebeparagravar) {
        recebeparagravar = pokemonService.save(recebeparagravar);
        if (recebeparagravar.getId() != null) {
            return "Salvo com sucesso!";
        } else {
            return "Não foi salvo!";
        }
    }

    @GetMapping(value = "/{id}")
    public PokemonModel findById(@PathVariable Integer id){
        return pokemonService.findById(id);
    }

    @PutMapping
    public PokemonModel atualizacaoPokemon(PokemonModel receverPokemon){
        return pokemonService.update(receverPokemon);
    }

    @DeleteMapping(value = "/{id}")
    public String deletePokemon(@PathVariable Integer id){
        return pokemonService.deleteById(id);
    }

    

}
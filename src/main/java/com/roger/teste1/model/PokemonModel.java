package com.roger.teste1.model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pokemon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pokemon")
public class PokemonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "nome", unique = true, nullable = false, length = 50)
    private String nome;

    @ColumnDefault(value = "100")
    @Column(name="vida", unique = false)
    private float vida;

    
}
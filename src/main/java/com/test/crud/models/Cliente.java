package com.test.crud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String nomeCompleto;

    private String sexo;
    
    private String dataNascimento;

    public int idade = 0;

    private String cidade;
    
}

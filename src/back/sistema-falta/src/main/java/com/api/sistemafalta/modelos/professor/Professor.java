package com.api.sistemafalta.modelos.professor;

import com.api.sistemafalta.modelos.materia.Materia;

public class Professor {
    private Integer id;
    private String nome;
    private Materia materia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}

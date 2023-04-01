package com.api.sistemafalta.modelos.professor;

import com.api.sistemafalta.modelos.materia.Materia;
import com.api.sistemafalta.modelos.turma.Turma;

public class Professor {
    private Integer id;
    private String nome;
    private Materia materia;
    private Turma turma;

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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}

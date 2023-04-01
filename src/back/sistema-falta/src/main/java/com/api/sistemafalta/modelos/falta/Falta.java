package com.api.sistemafalta.modelos.falta;

import java.util.Date;

import com.api.sistemafalta.modelos.aluno.Aluno;
import com.api.sistemafalta.modelos.materia.Materia;

public class Falta {
    private Integer id;
    private Date data;
    private Aluno aluno;
    private Materia materia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}

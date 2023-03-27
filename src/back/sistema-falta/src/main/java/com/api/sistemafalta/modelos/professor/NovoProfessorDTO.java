package com.api.sistemafalta.modelos.professor;

public class NovoProfessorDTO {
    private String nome;
    private Integer idMateria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }
}

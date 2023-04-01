package com.api.sistemafalta.modelos.falta;

public class NovaFaltaDTO {
    private Integer idAluno;
    private Integer idMateria;

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        return "NovaFaltaDTO [idAluno=" + idAluno + ", idMateria=" + idMateria + "]";
    }
}

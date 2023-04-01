package com.api.sistemafalta.modelos.aluno;

public class NovoAlunoDTO {
    private String nome;
    private Integer idTurma;
    private String emailResponsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    @Override
    public String toString() {
        return "NovoAlunoDTO [nome=" + nome + ", idTurma=" + idTurma + ", emailResponsavel=" + emailResponsavel + "]";
    }
}

package model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Tarefa {

    private String descricao;
    private int prioridade;
    private boolean concluida;
    private LocalDate dataCriacao;

    public Tarefa() {
    }

    public Tarefa(String descricao, int prioridade, boolean concluida, LocalDate dataCriacao) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = concluida;
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "descricao=" + descricao + ", prioridade=" + prioridade + ", concluida=" + concluida + ", dataCriacao=" + dataCriacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarefa other = (Tarefa) obj;
        if (this.prioridade != other.prioridade) {
            return false;
        }
        if (this.concluida != other.concluida) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return Objects.equals(this.dataCriacao, other.dataCriacao);
    }
}

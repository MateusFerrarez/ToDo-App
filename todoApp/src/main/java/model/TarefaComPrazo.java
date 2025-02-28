package model;

import java.time.LocalDate;
import java.util.Objects;


public class TarefaComPrazo extends Tarefa {

    private LocalDate prazo;

    public TarefaComPrazo() {
    }

    public TarefaComPrazo(LocalDate dataPrazo, String descricao, int prioridade, boolean concluida, LocalDate dataCriacao) {
        super(descricao, prioridade, concluida, dataCriacao);
        this.prazo = dataPrazo;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    @Override
    public String toString() {
        return super.toString() + ", dataPrazo=" + prazo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            final TarefaComPrazo other = (TarefaComPrazo) obj;
            return Objects.equals(this.prazo, other.prazo);
        }

        return false;
    }

}

package model;

import java.time.LocalDate;

public class TarefaSimples extends Tarefa {

    public TarefaSimples() {
    }
   
    public TarefaSimples(String descricao, int prioridade, boolean concluida, LocalDate dataCriacao) {
        super(descricao, prioridade, concluida, dataCriacao);
    }
}


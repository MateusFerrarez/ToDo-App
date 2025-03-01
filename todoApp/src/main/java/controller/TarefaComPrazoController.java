package controller;

import java.time.LocalDate;
import model.GerenciadorDeTarefas;
import model.TarefaComPrazo;

public class TarefaComPrazoController {
    public boolean addTarefaComPrazo(String descricao, int prioridade, LocalDate dataCriacao, LocalDate dataPrazo)  {
        final TarefaComPrazo novaTarefa = new TarefaComPrazo();
        novaTarefa.setConcluida(false);
        novaTarefa.setDataCriacao(dataCriacao);
        novaTarefa.setPrioridade(prioridade);
        novaTarefa.setDescricao(descricao);
        novaTarefa.setPrazo(dataPrazo);
        
        return GerenciadorDeTarefas.getInstance().add(novaTarefa);
    }
    
    public boolean removeTarefaComPrazo(TarefaComPrazo tarefaComPrazo){
        return GerenciadorDeTarefas.getInstance().remove(tarefaComPrazo);
    }
}

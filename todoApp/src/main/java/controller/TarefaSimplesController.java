/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.GerenciadorDeTarefas;
import java.time.LocalDate;
import model.TarefaSimples;

/**
 *
 * @author mateu
 */
public class TarefaSimplesController {

    public boolean addTarefaSimples(String descricao, int prioridade, LocalDate dataCriacao) {
        final TarefaSimples novaTarefa = new TarefaSimples();
        novaTarefa.setConcluida(false);
        novaTarefa.setDataCriacao(dataCriacao);
        novaTarefa.setPrioridade(prioridade);
        novaTarefa.setDescricao(descricao);

        return GerenciadorDeTarefas.getInstance().add(novaTarefa);
    }
    
    public boolean removeTarefaSimples(TarefaSimples tarefaSimples){
        return GerenciadorDeTarefas.getInstance().remove(tarefaSimples);
    }
}
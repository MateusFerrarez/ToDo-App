/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.GerenciadorDeTarefas;
import model.Tarefa;
import model.TarefaComPrazo;
import model.TarefaSimples;

/**
 *
 * @author mateu
 */
public class GerenciadorController {

    public void addTarefa(String descricao, int prioridade, boolean eSimples, LocalDate dtCriacao, LocalDate dtPrazo) {
        if (eSimples) {
            TarefaSimples tarefa = new TarefaSimples();
            tarefa.setConcluida(false);
            tarefa.setDataCriacao(dtCriacao);
            tarefa.setDescricao(descricao);
            tarefa.setPrioridade(prioridade);

            GerenciadorDeTarefas.getInstance().add(tarefa);

            JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso!", "Sucesso!", JOptionPane.DEFAULT_OPTION);

            return;
        }

        TarefaComPrazo tarefaComPrazo = new TarefaComPrazo();
        tarefaComPrazo.setConcluida(false);
        tarefaComPrazo.setDataCriacao(dtCriacao);
        tarefaComPrazo.setDescricao(descricao);
        tarefaComPrazo.setPrioridade(prioridade);
        tarefaComPrazo.setPrazo(dtPrazo);

        GerenciadorDeTarefas.getInstance().add(tarefaComPrazo);

        JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso!", "Sucesso!", JOptionPane.DEFAULT_OPTION);
    }

    public void removeTarefa(int index, JTable table) {
        List<Tarefa> tempList = new ArrayList<Tarefa>(GerenciadorDeTarefas.getInstance());
        GerenciadorDeTarefas.getInstance().clear();

        if (!tempList.isEmpty()) {
            tempList.remove(index);
        }

        JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!", "Sucesso!", JOptionPane.DEFAULT_OPTION);

        GerenciadorDeTarefas.getInstance().addAll(tempList);

        table.removeRowSelectionInterval(index, index);

        fillTable(table);
    }

    public static void fillTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        model.getDataVector().removeAllElements();

        for (Object obj : GerenciadorDeTarefas.getInstance()) {
            if (obj instanceof TarefaSimples) {
                TarefaSimples tarefa = (TarefaSimples) obj;
                final String estaConcluida = tarefa.isConcluida() ? "Concluida" : "Pendente";
                final String dtCriacao = formatter.format(tarefa.getDataCriacao()).toString();

                model.addRow(new Object[]{tarefa.getDescricao(), estaConcluida, tarefa.getPrioridade(), dtCriacao, "Não possui"});
            } else if (obj instanceof TarefaComPrazo) {
                TarefaComPrazo tarefa = (TarefaComPrazo) obj;
                final String estaConcluida = tarefa.isConcluida() ? "Concluida" : "Pendente";
                final String dtCriacao = formatter.format(tarefa.getDataCriacao()).toString();
                final String dtPrazo = formatter.format(tarefa.getPrazo()).toString();

                model.addRow(new Object[]{tarefa.getDescricao(), estaConcluida, tarefa.getPrioridade(), dtCriacao, dtPrazo});
            }
        };

    }
}

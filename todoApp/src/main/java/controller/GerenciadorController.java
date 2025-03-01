/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.GerenciadorDeTarefas;
import model.TarefaComPrazo;
import model.TarefaSimples;

/**
 *
 * @author mateu
 */
public class GerenciadorController {    
    public static void fillTable(JTable model) {
        DefaultTableModel teste = (DefaultTableModel) model.getModel();

        for (Object obj : GerenciadorDeTarefas.getInstance()) {
            if (obj instanceof TarefaSimples) {
                System.out.println("simples");

                TarefaSimples tarefa = (TarefaSimples) obj;
                
                teste.addRow(new Object[]{tarefa.getDescricao(), tarefa.getPrioridade()});
            } else if (obj instanceof TarefaComPrazo) {
                System.out.println("prazo");
            }
        };

    }
}

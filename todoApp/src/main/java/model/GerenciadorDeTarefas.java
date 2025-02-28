package model;


import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.TarefaComPrazo;
import model.TarefaSimples;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mateu
 */
public class GerenciadorDeTarefas {
     private static Collection lista = null;

    public static Collection getInstance() {
        if (lista == null) {
            lista = new ArrayList();
        }

        return lista;
    }
    
    public static void fillTable(JTable model) {
        DefaultTableModel teste = (DefaultTableModel) model.getModel();

        for (Object obj : lista) {
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

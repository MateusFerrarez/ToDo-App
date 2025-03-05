package model;

import java.util.ArrayList;
import java.util.Collection;

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

}

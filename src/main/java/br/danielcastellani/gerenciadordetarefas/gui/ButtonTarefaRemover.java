/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.gui;

import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.controle.TelaPrincipalControlador;
import br.danielcastellani.gerenciadordetarefas.modelo.Tarefa;
import javax.swing.JButton;

/**
 *
 * @author Rafael
 */

public class ButtonTarefaRemover extends JButton {

    private Tarefa tarefa;

    public ButtonTarefaRemover(Tarefa tarefa) {
        this.tarefa = tarefa;
        this.setText("Remover");

        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                removerTarefa(evt);
            }
        });
    }
    
//    public void removerTarefa(java.awt.event.ActionEvent evt) {
//        TelaPrincipalControlador controladorTelaPrincipal = (TelaPrincipalControlador) Contexto.getInstance().get(TelaPrincipalControlador.class.getCanonicalName());
//        controladorTelaPrincipal.removerProjeto(tarefa);
//    }
}

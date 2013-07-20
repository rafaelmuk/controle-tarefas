/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.gui;

import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.controle.TelaPrincipalControlador;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import javax.swing.JButton;

/**
 *
 * @author Rafael
 */

public class ButtonVisualizarTarefa extends JButton {

    private Projeto projeto;

    public ButtonVisualizarTarefa(Projeto projeto) {
        this.projeto = projeto;
        this.setText("Visualizar");

        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarTarefa(evt);
            }
        });
    }
    
    public void VisualizarTarefa(java.awt.event.ActionEvent evt) {
        TelaPrincipalControlador controladorTelaPrincipal = (TelaPrincipalControlador) Contexto.getInstance().get(TelaPrincipalControlador.class.getCanonicalName());
        controladorTelaPrincipal.VisualizarTarefa(projeto);
    }
}

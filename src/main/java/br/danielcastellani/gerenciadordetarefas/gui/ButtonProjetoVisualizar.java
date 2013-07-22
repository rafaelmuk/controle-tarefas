/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.gui;

import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.controle.TelaPrincipalControlador;
import br.danielcastellani.gerenciadordetarefas.controle.TelaVisualizarProjetoControlador;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import javax.swing.JButton;

/**
 *
 * @author Rafael
 */

public class ButtonProjetoVisualizar extends JButton {

    private Projeto projeto;

    public ButtonProjetoVisualizar(Projeto projeto) {
        this.projeto = projeto;
        this.setText("Visualizar");

        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarProjeto(evt);
            }
        });
    }
    
    public void VisualizarProjeto(java.awt.event.ActionEvent evt) {
//        TelaVisualizarProjetoControlador controladorTelaVisualizarProjeto = (TelaVisualizarProjetoControlador) Contexto.getInstance().get(TelaVisualizarProjetoControlador.class.getCanonicalName());
//        controladorTelaVisualizarProjeto.atualizaListagem();
        TelaPrincipalControlador controlador = (TelaPrincipalControlador) Contexto.getInstance().get(TelaPrincipalControlador.class.getCanonicalName());
        controlador.exibeTelaVisualizarProjeto(evt);
        
    }
}

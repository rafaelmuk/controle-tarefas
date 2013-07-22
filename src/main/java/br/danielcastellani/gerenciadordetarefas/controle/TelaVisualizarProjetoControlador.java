/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.controle;

import br.danielcastellani.gerenciadordetarefas.bd.BancoDeDados;
import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.gui.ButtonProjetoEditar;
import br.danielcastellani.gerenciadordetarefas.gui.ButtonProjetoRemover;
import br.danielcastellani.gerenciadordetarefas.gui.ButtonVisualizarProjeto;
import br.danielcastellani.gerenciadordetarefas.gui.TelaVisualizarTarefa;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public class TelaVisualizarProjetoControlador {

    private TelaVisualizarTarefa telaVisualizarProjeto;
    private String[] cabecalho = {"Nome", "Descrição", "Data_Venc", "Data_Cria","Data_fecha","Situação","","  Ações",""};

    public void listarProjetos() {
        if (telaVisualizarProjeto == null) {
            telaVisualizarProjeto = new TelaVisualizarTarefa();
            TelaPrincipalControlador controlador = (TelaPrincipalControlador) Contexto.getInstance().get(TelaPrincipalControlador.class.getCanonicalName());
            controlador.adicionarComponente(telaVisualizarProjeto);
        }
        atualizaListagem();
    }

    void esconde() {
        telaVisualizarProjeto.setVisible(false);
    }

    void atualizaListagem() {
        List<Projeto> projetos = BancoDeDados.getBancoDeDados().getListaProjetos();

        JPanel listagem = telaVisualizarProjeto.getPanelListagem();
        listagem.setLayout(new GridLayout(projetos.size() + 1, cabecalho.length));

        listagem.removeAll();
        System.gc();

        if (projetos.isEmpty()) {
            listagem.add(new JLabel("Não existem projetos."));
        } else {
            for (String itemDeCabecalho : cabecalho) {
                listagem.add(new JLabel(itemDeCabecalho));
            }

            for (Projeto projeto : projetos) {
                listagem.add(new JLabel(projeto.getNome()));
                listagem.add(new JLabel(projeto.getDescricao()));
                listagem.add(new ButtonProjetoEditar(projeto));
                listagem.add(new ButtonProjetoRemover(projeto));
                listagem.add(new ButtonVisualizarProjeto(projeto));
            }
        }
        telaVisualizarProjeto.pack();
        telaVisualizarProjeto.setVisible(true);
        telaVisualizarProjeto.repaint();
    }
}

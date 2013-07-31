/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.controle;

import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.gui.TelaTarefaListagem;
import br.danielcastellani.gerenciadordetarefas.gui.ButtonTarefaEditar;
import br.danielcastellani.gerenciadordetarefas.gui.ButtonTarefaRemover;
import br.danielcastellani.gerenciadordetarefas.modelo.Tarefa;
import br.danielcastellani.gerenciadordetarefas.bd.BancoDeDados;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public class TelaVisualizarProjetoControlador {

    private TelaTarefaListagem telaProjetoVisualizar;
    private String[] cabecalho = {"Nome", "Descrição", "Data_Venc", "Data_Cria","Data_fecha","Situação","","  Ações",""};

    public void listarTarefas() {
        if (telaProjetoVisualizar == null) {
            telaProjetoVisualizar = new TelaTarefaListagem();
//            TelaPrincipalControlador controlador = (TelaPrincipalControlador) Contexto.getInstance().get(TelaPrincipalControlador.class.getCanonicalName());
//            controlador.adicionarComponente(telaProjetoVisualizar);
        }
        atualizaListagem();
    }

    void esconde() {
        telaProjetoVisualizar.setVisible(false);
    }

    void atualizaListagem() {
        List<Tarefa> projetos = BancoDeDados.getBancoDeDados().getListaTarefas();
        JPanel listagem = telaProjetoVisualizar.getPanelListagem();
        listagem.setLayout(new GridLayout(projetos.size() + 1, cabecalho.length));

        listagem.removeAll();
        System.gc();

        if (projetos.isEmpty()) {
            listagem.add(new JLabel("Não existem projetos."));
        } else {
            for (String itemDeCabecalho : cabecalho) {
                listagem.add(new JLabel(itemDeCabecalho));
            }

            for (Tarefa tarefa : projetos) {
                listagem.add(new JLabel(tarefa.getNome()));
                listagem.add(new JLabel(tarefa.getDescricao()));
                listagem.add(new ButtonTarefaEditar(tarefa));
                listagem.add(new ButtonTarefaRemover(tarefa));
            }
        }
        telaProjetoVisualizar.pack();
        telaProjetoVisualizar.setVisible(true);
        telaProjetoVisualizar.repaint();
    }
}

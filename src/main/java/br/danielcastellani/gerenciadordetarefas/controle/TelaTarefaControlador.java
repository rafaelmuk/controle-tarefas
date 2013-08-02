/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.controle;


/**
 *
 * @author Rafael
 */ 

import br.danielcastellani.gerenciadordetarefas.bd.BancoDeDados;
import br.danielcastellani.gerenciadordetarefas.gui.TelaProjeto;
import br.danielcastellani.gerenciadordetarefas.gui.TelaTarefa;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import br.danielcastellani.gerenciadordetarefas.modelo.Tarefa;
import javax.swing.JOptionPane;

public class TelaTarefaControlador {

    TelaTarefa telaTarefa;

    public TelaTarefaControlador(TelaTarefa telaTarefa) {
        this.telaTarefa = telaTarefa;
    }

    public void salvar(Tarefa tarefa) {
        tarefa.setNome(telaTarefa.getTxtNome().getText());
        tarefa.setDescricao(telaTarefa.getTxtDescricao().getText());

        if (telaTarefa.isCriacao()) {
            BancoDeDados.getBancoDeDados().getListaTarefas().add(tarefa);
        }

        limparCampos();
        telaTarefa.setVisible(false);
        JOptionPane.showMessageDialog(telaTarefa, "Tarefa salva com sucesso");
    }

    public void fechar() {
        limparCampos();
        telaTarefa.setVisible(false);
    }

    private void limparCampos() {
        telaTarefa.getTxtNome().setText("");
        telaTarefa.getTxtDescricao().setText("");
    }
    
    public  void atualizaTelaEditar(Tarefa tarefaParaEditar) {
        telaTarefa.setTarefa(tarefaParaEditar);
        telaTarefa.getTxtNome().setText(tarefaParaEditar.getNome());
        telaTarefa.getTxtDescricao().setText(tarefaParaEditar.getDescricao());
    }

}


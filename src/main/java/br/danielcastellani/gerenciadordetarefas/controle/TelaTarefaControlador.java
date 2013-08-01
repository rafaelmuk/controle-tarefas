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
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import br.danielcastellani.gerenciadordetarefas.modelo.Tarefa;
import javax.swing.JOptionPane;

public class TelaTarefaControlador {

    TelaProjeto telaProjeto;

    public TelaTarefaControlador(TelaProjeto telaProjeto) {
        this.telaProjeto = telaProjeto;
    }

    public void salvar(Projeto projeto) {
//        tarefa.setNome(telaProjeto.getTxtNome().getText());
//        tarefa.setDescricao(telaProjeto.getTxtDescricao().getText());
//
//        if (telaProjeto.isCriacao()) {
//            BancoDeDados.getBancoDeDados().getListaTarefas().add(tarefa);
//        }
//
//        limparCampos();
//        telaProjeto.setVisible(false);
//        JOptionPane.showMessageDialog(telaProjeto, "Tarefa salva com sucesso");
    }

    public void fechar() {
        limparCampos();
        telaProjeto.setVisible(false);
    }

    private void limparCampos() {
        telaProjeto.getTxtNome().setText("");
        telaProjeto.getTxtDescricao().setText("");
    }
    
    public  void atualizaTelaEditar(Projeto projetoParaEditar) {
        telaProjeto.setProjeto(projetoParaEditar);
        telaProjeto.getTxtNome().setText(projetoParaEditar.getNome());
        telaProjeto.getTxtDescricao().setText(projetoParaEditar.getDescricao());
    }

}


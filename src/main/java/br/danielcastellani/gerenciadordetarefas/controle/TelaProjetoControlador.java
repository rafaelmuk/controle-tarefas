/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.controle;

import br.danielcastellani.gerenciadordetarefas.bd.BancoDeDados;
import br.danielcastellani.gerenciadordetarefas.gui.TelaProjeto;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import br.danielcastellani.gerenciadordetarefas.modelo.Tarefa;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class TelaProjetoControlador {

    TelaProjeto telaProjeto;

    public TelaProjetoControlador(TelaProjeto telaProjeto) {
        this.telaProjeto = telaProjeto;
    }

    public void salvar(Projeto projeto) {
        projeto.setNome(telaProjeto.getTxtNome().getText());
        projeto.setDescricao(telaProjeto.getTxtDescricao().getText());

        if (telaProjeto.isCriacao()) {
            BancoDeDados.getBancoDeDados().getListaProjetos().add(projeto);
        }

        limparCampos();
        telaProjeto.setVisible(false);
        JOptionPane.showMessageDialog(telaProjeto, "Projeto salvo com sucesso");
    }
    public void salvar(Tarefa tarefa) {
        tarefa.setNome(telaProjeto.getTxtNome().getText());
        tarefa.setDescricao(telaProjeto.getTxtDescricao().getText());

        if (telaProjeto.isCriacao()) {
            BancoDeDados.getBancoDeDados().getListaTarefas().add(tarefa);
        }

        limparCampos();
        telaProjeto.setVisible(false);
        JOptionPane.showMessageDialog(telaProjeto, "Projeto salvo com sucesso");
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

    void atualizaTelaVisualizar(Projeto projeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

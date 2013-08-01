/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.controle;

import br.danielcastellani.gerenciadordetarefas.bd.BancoDeDados;
import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.gui.ButtonTarefaEditar;
import br.danielcastellani.gerenciadordetarefas.gui.ButtonTarefaRemover;
import br.danielcastellani.gerenciadordetarefas.gui.TelaTarefa;
import br.danielcastellani.gerenciadordetarefas.gui.TelaTarefaListagem;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import br.danielcastellani.gerenciadordetarefas.modelo.Tarefa;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public class TelaTarefaListagemControlador {

    private TelaTarefaListagem telaTarefaListagem;
    private TelaTarefa telaTarefa;
    private String[] cabecalho = {"Nome", "Descrição", "Data_Venc", "Data_Cria","Data_fecha","Situação","","  Ações",""};
    public TelaTarefaListagemControlador(){

    }
    public TelaTarefaListagemControlador(TelaTarefaListagem telaTarefaListagem){
        this.telaTarefaListagem=telaTarefaListagem;
    }
    public void listarTarefas(Projeto projeto) {
        if (telaTarefaListagem == null) {
            telaTarefaListagem = new TelaTarefaListagem();
            TelaPrincipalControlador controlador = (TelaPrincipalControlador) Contexto.getInstance().get(TelaPrincipalControlador.class.getCanonicalName());
            controlador.adicionarComponente(telaTarefaListagem);
        }
        atualizaListagem();
    }
        
    void esconde() {
        telaTarefaListagem.setVisible(false);
    }

    void atualizaListagem() {
        List<Tarefa> tarefas = BancoDeDados.getBancoDeDados().getListaTarefas();
        JPanel listagem = telaTarefaListagem.getPanelListagem();
        listagem.setLayout(new GridLayout(/*tarefas.size() + 1, cabecalho.length*/));

        listagem.removeAll();
        System.gc();

        if (tarefas.isEmpty()) {
            listagem.add(new JLabel("Não existem projetos."));
        } else {
            for (String itemDeCabecalho : cabecalho) {
                listagem.add(new JLabel(itemDeCabecalho));
            }

            for (Tarefa tarefa : tarefas) {
                listagem.add(new JLabel(tarefa.getNome()));
                listagem.add(new JLabel(tarefa.getDescricao()));
                listagem.add(new ButtonTarefaEditar(tarefa));
                listagem.add(new ButtonTarefaRemover(tarefa));
            }
        }
        telaTarefaListagem.pack();
        telaTarefaListagem.setVisible(true);
        telaTarefaListagem.repaint();
    }
//    public void atualizaTelaVisualizar(Tarefa tarefa) {
//                    telaTarefa.setTarefa(projeto);
//                    telaTarefa.getTxtNome().setText(projeto.getNome());
//                    telaTarefa.getTxtDescricao().setText(projeto.getDescricao());
//        }
}

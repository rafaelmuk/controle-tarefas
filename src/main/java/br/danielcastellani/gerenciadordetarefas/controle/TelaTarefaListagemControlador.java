/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.controle;

import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.gui.TelaTarefaListagem;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public class TelaTarefaListagemControlador {

    private TelaTarefaListagem telaTarefaListagem;
    private String[] cabecalho = {"Nome", "Descrição", "Data_Venc", "Data_Cria","Data_fecha","Situação","","  Ações",""};
    public TelaTarefaListagemControlador(){

    }
    public TelaTarefaListagemControlador(TelaTarefaListagem telaTarefaListagem){
        this.telaTarefaListagem=telaTarefaListagem;
    }
    public void listarTarefas(Projeto projeto) {
        if (telaTarefaListagem == null) {
            telaTarefaListagem = new TelaTarefaListagem(projeto);
            TelaPrincipalControlador controlador = (TelaPrincipalControlador) Contexto.getInstance().get(TelaPrincipalControlador.class.getCanonicalName());
            controlador.adicionarComponente(telaTarefaListagem);
        }
        atualizaListagem();
    }
        
    void esconde() {
        telaTarefaListagem.setVisible(false);
    }

    void atualizaListagem() {
//        List<Tarefa> projetos = BancoDeDados.getBancoDeDados().getListaTarefas();
        JPanel listagem = telaTarefaListagem.getPanelListagem();
        listagem.setLayout(new GridLayout(/*projetos.size() + 1, cabecalho.length*/));

//        listagem.removeAll();
//        System.gc();
//
//        if (projetos.isEmpty()) {
//            listagem.add(new JLabel("Não existem projetos."));
//        } else {
//            for (String itemDeCabecalho : cabecalho) {
//                listagem.add(new JLabel(itemDeCabecalho));
//            }
//
//            for (Tarefa tarefa : projetos) {
//                listagem.add(new JLabel(tarefa.getNome()));
//                listagem.add(new JLabel(tarefa.getDescricao()));
//                listagem.add(new ButtonTarefaEditar(tarefa));
//                listagem.add(new ButtonTarefaRemover(tarefa));
//            }
//        }
        telaTarefaListagem.pack();
        telaTarefaListagem.setVisible(true);
        telaTarefaListagem.repaint();
    }
    public void atualizaTelaVisualizar(Projeto projeto) {
                    telaTarefaListagem.setProjeto(projeto);
                    telaTarefaListagem.getTxtNome().setText(projeto.getNome());
                    telaTarefaListagem.getTxtDescricao().setText(projeto.getDescricao());
        }
}

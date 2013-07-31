/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.controle;

import br.danielcastellani.gerenciadordetarefas.bd.BancoDeDados;
import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.gui.TelaPrincipal;
import br.danielcastellani.gerenciadordetarefas.gui.TelaProjeto;
import br.danielcastellani.gerenciadordetarefas.gui.TelaProjetoFactory;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;

/**
 *
 * @author Daniel
 */
public class TelaPrincipalControlador {

    private TelaPrincipal telaPrincipal;
    private TelaProjeto telaProjetoCriar;
    private TelaProjeto telaProjetoEditar;
    private TelaVisualizarProjetoControlador telaProjetoVisualizar;

    public TelaPrincipalControlador() {
        this.telaPrincipal = new TelaPrincipal();
    }

    public void exibeTelaSobre(java.awt.event.ActionEvent evt) {
        TelaSobreControlador controlador = (TelaSobreControlador) Contexto.getInstance().get(TelaSobreControlador.class.getCanonicalName());
        controlador.exibeTelaSobre();
    }

    public void exibeTelaProjetosListagem(ActionEvent evt) {
        TelaProjetoListagemControlador controlador = (TelaProjetoListagemControlador) Contexto.getInstance().get(TelaProjetoListagemControlador.class.getCanonicalName());
        controlador.listarProjetos();
    }
    
    public void exibeTelaVisualizarProjeto(ActionEvent evt) {
        TelaProjetoListagemControlador controladorListagem = (TelaProjetoListagemControlador) Contexto.getInstance().get(TelaProjetoListagemControlador.class.getCanonicalName());
        controladorListagem.esconde();
        
        TelaVisualizarProjetoControlador VisualizarProjeto = (TelaVisualizarProjetoControlador) Contexto.getInstance().get(TelaVisualizarProjetoControlador.class.getCanonicalName());
                    System.out.println("jjjjjjjjjjjjjj");
        VisualizarProjeto.listarTarefas();

    }

    public void exibeTelaCriarNovoProjeto(ActionEvent evt) {
        criaTelaSeNaoExistir();
        telaProjetoCriar.pack();
        telaProjetoCriar.setVisible(true);
        telaProjetoCriar.setProjeto(new Projeto());
    }

    public void editarProjeto(Projeto projeto) {
        TelaProjetoListagemControlador controladorListagem = (TelaProjetoListagemControlador) Contexto.getInstance().get(TelaProjetoListagemControlador.class.getCanonicalName());
        controladorListagem.esconde();

        if (telaProjetoEditar == null) {
            telaProjetoEditar = TelaProjetoFactory.criaTelaEditarProjeto(projeto);
            telaPrincipal.getContentPane().add(telaProjetoEditar);
        }
        telaProjetoEditar.setVisible(true);

        TelaProjetoControlador controladorEditar = (TelaProjetoControlador) Contexto.getInstance().get(TelaProjetoControlador.class.getCanonicalName());
        controladorEditar.atualizaTelaEditar(projeto);
    }

    public void exibeTelaPrincipal() {
        telaPrincipal.setVisible(true);
    }

    void adicionarComponente(JComponent component) {
        telaPrincipal.getContentPane().add(component);
    }

    private void criaTelaSeNaoExistir() {
        if (telaProjetoCriar == null) {
            telaProjetoCriar = TelaProjetoFactory.criaTelaNovoProjeto();
            telaPrincipal.getContentPane().add(telaProjetoCriar);
        }
    }

    public void removerProjeto(Projeto projeto) {
        BancoDeDados.getBancoDeDados().getListaProjetos().remove(projeto);

        TelaProjetoListagemControlador controladorListagem = (TelaProjetoListagemControlador) Contexto.getInstance().get(TelaProjetoListagemControlador.class.getCanonicalName());
        controladorListagem.atualizaListagem();
    }

} 

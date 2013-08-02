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
import br.danielcastellani.gerenciadordetarefas.gui.TelaTarefa;
import br.danielcastellani.gerenciadordetarefas.gui.TelaTarefaFactory;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import br.danielcastellani.gerenciadordetarefas.modelo.Tarefa;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;


public class TelaPrincipalControlador {

    private TelaPrincipal telaPrincipal;
    private TelaProjeto telaProjetoCriar;
    private TelaProjeto telaProjetoEditar;
    private TelaTarefa telaTarefaEditar;
    private TelaTarefa telaTarefaCriar;

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
    
    public void exibeTelaTarefasListagem(ActionEvent evt,Projeto projeto) {
         TelaProjetoListagemControlador controladorListagem = (TelaProjetoListagemControlador) Contexto.getInstance().get(TelaProjetoListagemControlador.class.getCanonicalName());
        controladorListagem.esconde();
         TelaTarefaListagemControlador controlador = (TelaTarefaListagemControlador) Contexto.getInstance().get(TelaTarefaListagemControlador.class.getCanonicalName());
         controlador.listarTarefas(projeto);  
    }
    public void exibeTelaCriarNovoProjeto(ActionEvent evt) {
        criaTelaSeNaoExistir();
        telaProjetoCriar.pack();
        telaProjetoCriar.setVisible(true);
        telaProjetoCriar.setProjeto(new Projeto());
    }
    public void exibeTelaCriarNovaTarefa(ActionEvent evt) {
        TelaTarefaListagemControlador controladorListagem = (TelaTarefaListagemControlador) Contexto.getInstance().get(TelaTarefaListagemControlador.class.getCanonicalName());
        controladorListagem.esconde();
        
        criaTelaSeNaoExistirTarefa();
        telaTarefaCriar.pack();
        telaTarefaCriar.setVisible(true);
        telaTarefaCriar.setTarefa(new Tarefa());
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
    
  public void editarTarefa(Tarefa tarefa) {
        TelaTarefaListagemControlador controladorListagem = (TelaTarefaListagemControlador) Contexto.getInstance().get(TelaTarefaListagemControlador.class.getCanonicalName());
        controladorListagem.esconde();

        if (telaTarefaEditar == null) {
            telaTarefaEditar = TelaTarefaFactory.criaTelaEditarTarefa(tarefa);
            telaPrincipal.getContentPane().add(telaTarefaEditar);
        }
        telaTarefaEditar.setVisible(true);

        TelaTarefaControlador controladorEditar = (TelaTarefaControlador) Contexto.getInstance().get(TelaTarefaControlador.class.getCanonicalName());
        controladorEditar.atualizaTelaEditar(tarefa);
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
    
    public void removerTarefa(Tarefa tarefa,Projeto projeto) {
        projeto.getTarefas().remove(tarefa);
        TelaTarefaListagemControlador controladoListagem = (TelaTarefaListagemControlador) Contexto.getInstance().get(TelaTarefaListagemControlador.class.getCanonicalName());
        controladoListagem.atualizaListagem(projeto);
    }

    private void criaTelaSeNaoExistirTarefa() {
        //if (telaTarefaCriar == null) {
            telaTarefaCriar = TelaTarefaFactory.criaTelaNovaTarefa();
            telaPrincipal.getContentPane().add(telaTarefaCriar);
        //}
    }

} 

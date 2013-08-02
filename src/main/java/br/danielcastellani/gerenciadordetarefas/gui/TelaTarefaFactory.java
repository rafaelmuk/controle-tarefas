/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.gui;

import br.danielcastellani.gerenciadordetarefas.modelo.Tarefa;

/**
 *
 * @author DanCastellani
 */
public class TelaTarefaFactory {

    public static TelaTarefa criaTelaNovaTarefa() {
        return new TelaTarefa(TelaTarefa.OPCAO_NOVA_TAREFA, new Tarefa());
    }

    public static TelaTarefa criaTelaEditarTarefa(Tarefa tarefaParaEditar) {
        TelaTarefa telaTarefa = new TelaTarefa(TelaTarefa.OPCAO_EDITAR_TAREFA, tarefaParaEditar);
        telaTarefa.atualizaTelaEditar(telaTarefa, tarefaParaEditar);
        return telaTarefa;
    }    
    
}

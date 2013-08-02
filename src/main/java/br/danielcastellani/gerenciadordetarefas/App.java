package br.danielcastellani.gerenciadordetarefas;

import br.danielcastellani.gerenciadordetarefas.bd.BancoDeDados;
import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.controle.TelaPrincipalControlador;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import br.danielcastellani.gerenciadordetarefas.modelo.Tarefa;
import java.util.GregorianCalendar;
import java.util.List;

public class App {

    public static void main(String[] args) {
        //remover depois
        List<Tarefa> tarefas;
        List<Projeto> projetos = BancoDeDados.getBancoDeDados().getListaProjetos();
        Projeto a = new Projeto("Projeto 1", "Ipson Loren 1");
        projetos.add(a);
        a.setTarefas("tarefa1", "descrição","03/08/20013","02/08/20013","03/08/20013","");
//        a.setTarefas("nome","descrição");
//        projetos.add(new Projeto("Projeto 2", "Ipson Loren 2"));
//        projetos.add(new Projeto("Projeto 3", "Ipson Loren 3"));
//        projetos.add(new Projeto("Projeto 4", "Ipson Loren 4"));
        TelaPrincipalControlador controlador = (TelaPrincipalControlador) Contexto.getInstance().get(TelaPrincipalControlador.class.getCanonicalName());
        controlador.exibeTelaPrincipal();
    }
}

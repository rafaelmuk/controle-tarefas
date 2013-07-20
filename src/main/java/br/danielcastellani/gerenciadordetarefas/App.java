package br.danielcastellani.gerenciadordetarefas;

import br.danielcastellani.gerenciadordetarefas.bd.BancoDeDados;
import br.danielcastellani.gerenciadordetarefas.contexto.Contexto;
import br.danielcastellani.gerenciadordetarefas.controle.TelaPrincipalControlador;
import br.danielcastellani.gerenciadordetarefas.modelo.Projeto;
import java.util.List;

public class App {

    public static void main(String[] args) {
        //remover depois
        List<Projeto> projetos = BancoDeDados.getBancoDeDados().getListaProjetos();
        projetos.add(new Projeto("Projeto 1", "Ipson Loren 1","Em andamento"));
        projetos.add(new Projeto("Projeto 2", "Ipson Loren 2","Parado"));
        projetos.add(new Projeto("Projeto 3", "Ipson Loren 3","Finalizado"));
        projetos.add(new Projeto("Projeto 4", "Ipson Loren 4","Em andamento"));
        TelaPrincipalControlador controlador = (TelaPrincipalControlador) Contexto.getInstance().get(TelaPrincipalControlador.class.getCanonicalName());
        controlador.exibeTelaPrincipal();
    }
}

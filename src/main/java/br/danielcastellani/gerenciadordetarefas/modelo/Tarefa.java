/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author Rafael
 */

public class Tarefa {

    private Projeto projeto;
    private String nome;
    private String descricao;
    private GregorianCalendar data_Cria;
    private GregorianCalendar data_Termina;
    private GregorianCalendar data_Venc;
    private String situacao;
    
    public Tarefa(Projeto projeto, String nome, String descricao, GregorianCalendar dataVenc) {
        this.nome = nome;
        this.projeto = projeto;
        this.nome = nome;
        this.descricao = descricao;
        this.data_Venc = dataVenc;
        this.data_Cria = new GregorianCalendar();
        this.situacao = "A Fazer";
    }
    
    
    public GregorianCalendar getDataCriacao() {
        return data_Cria;
    }

   
    public GregorianCalendar getDataTermino() {
        return data_Termina;
    }

 
    public GregorianCalendar getDataVencimento() {
        return data_Venc;
    }

    /**
     * @return the projeto
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * @param projeto the projeto to set
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
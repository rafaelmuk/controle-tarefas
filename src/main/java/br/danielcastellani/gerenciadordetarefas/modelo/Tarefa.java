/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.danielcastellani.gerenciadordetarefas.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Rafael
 */

public class Tarefa implements Serializable{

    private Projeto projeto;
    private String nome;
    private String descricao;
    private String data_Cria;
    private String data_Termina;
    private String data_Venc;
    private String situacao;
    
    public Tarefa(String nome, String descricao, String data_Venc,String data_Cria,String data_Termina,String Situacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_Venc = data_Venc;
        this.data_Cria = data_Cria;
        this.data_Termina = data_Termina;
        this.situacao = Situacao;
        this.situacao = "A Fazer";
    }
    
    public Tarefa() {
    }
    public String getDataCriacao() {
        return data_Cria;
    }

   
    public String getDataTermino() {
        return data_Termina;
    }

 
    public String getDataVencimento() {
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
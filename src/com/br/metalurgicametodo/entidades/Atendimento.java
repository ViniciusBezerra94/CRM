/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.entidades;

import java.util.Date;

/**
 *
 * @author MarceloSilva
 */
//Classe que sera responsavel por armazenar Atendimento
public class Atendimento {
    
    private int Protocolo;
    private String tipoContato;
    private java.sql.Date dataContato; 
    private String descricao;
    private Pessoa pessoa;
    private Venda venda;
    private String tipoAssunto;
    private String motivo;
    private String solucao;
    private String status;
    
    public Atendimento(){
        
    }

    public Atendimento(int Protocolo, String tipoContato, java.sql.Date dataContato, String descricao, Pessoa pessoa, Venda venda, String tipoAssunto, String motivo, String solucao, String status) {
        this.Protocolo = Protocolo;
        this.tipoContato = tipoContato;
        this.dataContato = dataContato;
        this.descricao = descricao;
        this.pessoa = pessoa;
        this.venda = venda;
        this.tipoAssunto = tipoAssunto;
        this.motivo = motivo;
        this.solucao = solucao;
        this.status = status;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public java.sql.Date getDataContato() {
        return dataContato;
    }

    public void setDataContato(java.sql.Date dataContato) {
        this.dataContato = dataContato;
    }

    public String getTipoAssunto() {
        return tipoAssunto;
    }

    public void setTipoAssunto(String tipoAssunto) {
        this.tipoAssunto = tipoAssunto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }



    public int getProtocolo() {
        return Protocolo;
    }

    public void setProtocolo(int Protocolo) {
        this.Protocolo = Protocolo;
    }



    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "Protocolo=" + Protocolo + ", tipoContato=" + tipoContato + ", dataContato=" + dataContato + ", descricao=" + descricao + ", pessoa=" + pessoa + ", venda=" + venda + ", tipoAssunto=" + tipoAssunto + ", motivo=" + motivo + ", solucao=" + solucao + ", status=" + status + '}';
    }
    
    
}

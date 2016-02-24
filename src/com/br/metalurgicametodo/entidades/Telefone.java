/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.entidades;

/**
 *
 * @author MarceloSilva
 */
//Classe que sera responsavel por armazenar Telefone
public class Telefone {
    
    private Pessoa pessoa;
    private String telefoneCelular;
    private String telefoneFixo;
    
    public Telefone(){
        
    }

    public Telefone(Pessoa pessoa, String telefoneCelular, String telefoneFixo) {
        this.pessoa = pessoa;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }
    
    
    
}

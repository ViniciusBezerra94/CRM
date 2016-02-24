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
//Classe que sera responsavel por armazenar Pessoa Juridica
public class PessoaJuridica {
    
    private Pessoa pessoa;
    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    
    public PessoaJuridica(){
        
    }

    public PessoaJuridica(Pessoa tipo, String cnpj, String nomeFantasia, String razaoSocial) {
        this.pessoa = tipo;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa tipo) {
        this.pessoa = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    
    
    
}

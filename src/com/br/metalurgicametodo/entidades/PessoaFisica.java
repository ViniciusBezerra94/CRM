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
//Classe que sera responsavel por armazenar Pessoa Fisica
public class PessoaFisica {
    
    private Pessoa pessoa;
    private String cpf;
    private String rg;
    private java.sql.Date dataNascimento;
    private String sexo;
    
    private String estadoCivil;
    
    
    public PessoaFisica(){
        
    }

    public PessoaFisica(Pessoa pessoa, String cpf, String rg, java.sql.Date dataNascimento, String sexo, String email, String estadoCivil) {
        this.pessoa = pessoa;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
       
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

 

    public java.sql.Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(java.sql.Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }




    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa tipo) {
        this.pessoa = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "pessoa=" + pessoa + ", cpf=" + cpf + ", rg=" + rg + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + '}';
    }

  
   
    
    

    
}

package com.br.metalurgicametodo.entidades;

//Classe que sera responsavel por armazenar Pessoa
public class Pessoa {

    private int codigoPessoa;
    private String nome;
    private String tipoPessoa;
    private String cep;
    private String rua;
    private String uf;
    private String cidade;
    private String bairro;
    private int numero;
    private String email;
    
    
    public Pessoa(){
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codigoPessoa=" + codigoPessoa + ", nome=" + nome + ", tipoPessoa=" + tipoPessoa + ", cep=" + cep + ", rua=" + rua + ", uf=" + uf + ", cidade=" + cidade + ", bairro=" + bairro + ", numero=" + numero + '}';
    }

    public Pessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public Pessoa(int codigoPessoa, String nome, String tipoPessoa, String cep, String rua, String uf, String cidade, String bairro, int numero, String email) {
        this.codigoPessoa = codigoPessoa;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.cep = cep;
        this.rua = rua;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.email = email;
    }

    

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }



    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    

   

}

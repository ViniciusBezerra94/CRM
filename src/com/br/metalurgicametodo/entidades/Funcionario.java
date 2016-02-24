package com.br.metalurgicametodo.entidades;

import java.util.Date;
//Classe que sera responsavel por armazenar Funcionario
public class Funcionario {

    private int id_funcionario;
    private String nome;
    private String login;
    private String cargo;
    private String senha;
    private int re;

    public Funcionario() {

    }

    public Funcionario(int id_funcionaio, String nome, String login, String cargo, String senha, int re) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.login = login;
        this.cargo = cargo;
        this.senha = senha;
        this.re = re;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }

}

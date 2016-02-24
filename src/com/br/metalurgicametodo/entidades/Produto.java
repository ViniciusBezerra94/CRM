package com.br.metalurgicametodo.entidades;

/**
 * @author rds_d
 * @version 1.0
 * @created 21-set-2015 12:51:54
 */
//Classe que sera responsavel por armazenar Produto
public class Produto {
    private int codigoProduto;
    private String descricao;
    private String tipo;
    private String nome;

    public Produto() {

    }

    public Produto(int codigoProduto, String descricao, String tipo, String nome) {
        this.codigoProduto = codigoProduto;
        this.descricao = descricao;
        this.tipo = tipo;
        this.nome = nome;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

}

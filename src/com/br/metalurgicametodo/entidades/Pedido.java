package com.br.metalurgicametodo.entidades;

import java.util.Date;
//Classe que sera responsavel por armazenar Pedido
public class Pedido {
    private int numeroPedido;
    private Date dataPedido;
    private Produto tipoProduto;
    private Pessoa pessoa;
    
    private int quantidade;
    private String statusDoPedido;

    public Pedido() {

    }

    public Pedido(int numeroPedido, Date dataPedido, Produto tipoProduto, Pessoa pessoa, Venda venda, int quantidade, String statusDoPedido) {
        this.numeroPedido = numeroPedido;
        this.dataPedido = dataPedido;
        this.tipoProduto = tipoProduto;
        this.pessoa = pessoa;
        
        this.quantidade = quantidade;
        this.statusDoPedido = statusDoPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }



 

    public Produto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(Produto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }



    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatusDoPedido() {
        return statusDoPedido;
    }

    public void setStatusDoPedido(String statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }
    
    

   

}

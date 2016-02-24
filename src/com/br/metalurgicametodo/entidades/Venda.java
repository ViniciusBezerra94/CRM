package com.br.metalurgicametodo.entidades;

//Classe que sera responsavel por armazenar Venda
public class Venda {

    private int codigoVenda;
    private int notaFiscal;
    private double valorVenda;

    public Venda() {

    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(int notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Venda(int codigoVenda, int notaFiscal, double valorVenda) {
        this.codigoVenda = codigoVenda;
        this.notaFiscal = notaFiscal;
        this.valorVenda = valorVenda;
    }

    

}

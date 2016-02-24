/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.dao;

import com.br.metalurgicametodo.entidades.Funcionario;
import com.br.metalurgicametodo.entidades.Produto;
import com.br.metalurgicametodo.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
//Classe de CRUD do banco de dados
public class ProdutoDAO extends DaoBase {

    Conexao conexao = new Conexao();

// metodo utilizado para salvar um Objeto do tipo produto no banco de dados    
    @Override
    public void save(Object objeto) {
        Produto produto = (Produto) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "insert into Produto(codigo_produto,Descricao_produto,Tipo_produto,nome) values (?,?,?,?)";
            insereSt = con.prepareStatement(sql);
            insereSt.setInt(1, produto.getCodigoProduto());
            insereSt.setString(2, produto.getDescricao());
            insereSt.setString(3, produto.getTipo());
            insereSt.setString(4, produto.getNome());

            System.out.println("Adicionou o produto");
            insereSt.executeUpdate();

        } catch (Throwable e) {
            System.out.println("Erro ao incluir contato. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    insereSt.close();
                    con.close();

                }
                System.out.println("Fim conexao");
            } catch (Throwable e) {
                System.out.println("houve algum problema ao encerrar a conexão: " + e.getMessage());
            }
        }
    }

    //classe utilizado para buscar um produto atravez de seu ID no banco de dados, passando como paremetro um id
    // retorna um objeto de produto
    public Produto buscar(int id) {

        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        Produto produto = null;

        String sql = "select * from Produto where codigo_produto = " + id;
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                Produto prod = new Produto();
                prod.setCodigoProduto(resultado.getInt("Codigo_Produto"));
                prod.setDescricao(resultado.getString("Descricao_Produto"));
                prod.setTipo(resultado.getString("Tipo_produto"));
                prod.setNome(resultado.getString("nome"));
                produto = prod;

            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de contato. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {
                    consulta.close();
                    resultado.close();
                    con.close();
                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }
        return produto;
    }

    // metodo utilizado para deletar um produto no banco de dados
    @Override
    public void delete(Object objeto) {
        Produto produto = (Produto) objeto;
        PreparedStatement delete = null;
        Connection con = null;
        String sql = "DELETE FROM Funcionario WHERE id_funcionario = ?";
        try {
            con = conexao.getConexao();
            delete = con.prepareStatement(sql);

            delete.setInt(1, produto.getCodigoProduto());

            delete.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao incluir contato. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {
                    delete.close();
                    con.close();
                }
            } catch (Throwable f) {
                System.out.println("Erro ao tentar fechar conexao. Mensagem: " + f.getMessage());
            }

        }
    }

    //metodo utilizado para criar uma lista de produtos atravez de itens cadastrados no banco
    @Override
    public List list() {
        Connection con = null;
        List<Produto> produto = new ArrayList();
        Statement consulta = null;
        ResultSet resultado = null;
        Produto prod = null;

        String sql = "select * from Funcionario order by id_funcionario";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                prod= new Produto();
               prod.setCodigoProduto(resultado.getInt("Codigo_Produto"));
                prod.setDescricao(resultado.getString("Descricao_Produto"));
                prod.setTipo(resultado.getString("Tipo_produto"));
                prod.setNome(resultado.getString("nome"));

                produto.add(prod);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de contato. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {
                    consulta.close();
                    resultado.close();
                    con.close();
                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }
        return produto;
    }


    
    
    
}

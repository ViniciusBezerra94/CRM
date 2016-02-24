/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.dao;

import com.br.metalurgicametodo.entidades.Funcionario;
import com.br.metalurgicametodo.entidades.Pedido;
import com.br.metalurgicametodo.entidades.Pessoa;
import com.br.metalurgicametodo.entidades.Produto;

import com.br.metalurgicametodo.conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
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
//Classe de Crud do Banco
public class PedidoDAO extends DaoBase {

    Conexao conexao = new Conexao();
    //Metodo utilizado para salvar um  objeto Pedido no banco de dados
    @Override
    public void save(Object objeto) {
        
        Pedido pedido = (Pedido) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "insert into Pedido(numero_pedido,status,data_pedido,tipo_produto,codigo_pessoa) values (?,?,?,?,?)";
            insereSt = con.prepareStatement(sql);
            insereSt.setInt(1,pedido.getNumeroPedido());
            insereSt.setString(2, pedido.getStatusDoPedido());
            insereSt.setDate(3, (java.sql.Date) pedido.getDataPedido());
            insereSt.setObject(4, pedido.getTipoProduto().getCodigoProduto());
            insereSt.setObject(5, pedido.getPessoa().getCodigoPessoa());
           
       
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

    //Metodo utilizado para criar uma lista com Pedido do banco de dados
    @Override
    public List list() {
       Connection con = null;
        List<Pedido> pedido = new ArrayList();
        Statement consulta = null;
        ResultSet resultado = null;
        Pedido pedidos = null;

        String sql = "select * from Pedido order by Numero_Pedido";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                Pedido ped = new Pedido();
                ped.setNumeroPedido(resultado.getInt("Numero_Pedido"));
                ped.setStatusDoPedido(resultado.getString("Status"));
                ped.setDataPedido(resultado.getDate("data_pedido"));
                Produto prod = new Produto();
                prod.setCodigoProduto(resultado.getInt("Tipo_produto"));
                ProdutoDAO proDAO = new ProdutoDAO();
                //ped.setTipoProduto(new Produto((int) resultado.getObject("Tipo_produto")));
                ped.setTipoProduto(proDAO.buscar(prod.getCodigoProduto()));
                Pessoa p = new Pessoa();
                p.setCodigoPessoa(resultado.getInt("Codigo_pessoa"));
                PessoaDao pessoaDAO = new PessoaDao();
                //pessoaDAO.buscar(p.getCodigoPessoa());
                
                ped.setPessoa(p);
                

                pedido.add(ped);
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
        return pedido;
    }
//Metodo utilizado para deletar um objeto Pedido no banco de dados
    @Override
    public void delete(Object objeto) {
        Pedido pedido = (Pedido) objeto;
        PreparedStatement delete = null;
        Connection con = null;
        String sql = "DELETE FROM Funcionario WHERE id_funcionario = ?";
        try {
            con = conexao.getConexao();
            delete = con.prepareStatement(sql);

            delete.setInt(1, pedido.getNumeroPedido());

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
       
   //Metodo utilizado para alterar um  objeto Pedido no banco de dados
    @Override
    public void update(Object objeto) {
        Pedido pedido = (Pedido) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "UPDATE Pedido SET data_pedido = ?, tipo_produto = ?, Status = ? , id_ = ? , re = ? WHERE id_funcionario = ?";
            insereSt = con.prepareStatement(sql);

            insereSt.setDate(1, (java.sql.Date)pedido.getDataPedido());
            insereSt.setInt(2, pedido.getTipoProduto().getCodigoProduto());
            insereSt.setString(3, pedido.getStatusDoPedido());

            System.out.println("Adicionou o povo");
            
            

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
    
}

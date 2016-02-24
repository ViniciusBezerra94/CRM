/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.dao;

import com.br.metalurgicametodo.entidades.Funcionario;
import com.br.metalurgicametodo.entidades.Venda;
import com.br.metalurgicametodo.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Vinicius
 */
//Classe de Crud do banco de dados
public class VendaDAO extends DaoBase {
    Conexao conexao = new Conexao();
   
   // metodo utilizado para salvar um objeto do tipo venda no banco de dados 
    @Override
    public void save(Object objeto) {
        Venda venda = (Venda) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "insert into venda(codigo_venda,nota_fiscal,valor_venda) values (?,?,?,?)";
            insereSt = con.prepareStatement(sql);
            
            //insereSt.setInt(1, id_funcionario_seq.nextVal);
            insereSt.setInt(1, venda.getCodigoVenda());
            insereSt.setInt(2, venda.getNotaFiscal());
            insereSt.setDouble(3, venda.getValorVenda());
            System.out.println("Adicionou a venda");
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

    //metodo utilizado para deletar uma objeto do tipo venda do banco dedados
    @Override
    public void delete(Object objeto) {
         Venda venda = (Venda) objeto;
        PreparedStatement delete = null;
        Connection con = null;
        String sql = "DELETE FROM venda WHERE codigo_venda = ?";
        try {
            con = conexao.getConexao();
            delete = con.prepareStatement(sql);
           
            
            
            delete.setInt(1, venda.getCodigoVenda());

            delete.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao incluir contato. Mensagem: " + e.getMessage());
        } finally {
           try{
               if(!con.isClosed())
               {
                   delete.close();
                   con.close();
               }
           }catch(Throwable f)
           {
               System.out.println("Erro ao tentar fechar conexao. Mensagem: " + f.getMessage());
           }

        }
    }

 //metodo que altera uma venda no banco de dados   
    @Override
    public void update(Object objeto) {
        Venda venda = (Venda) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "UPDATE Venda SET  nota_fiscal = ? , valor_venda = ? WHERE codigo_venda = ?";
            insereSt = con.prepareStatement(sql);
            
            insereSt.setInt(1, venda.getNotaFiscal());
            insereSt.setDouble(2, venda.getValorVenda());
            insereSt.setInt(3, venda.getCodigoVenda());
            
            System.out.println("Adicionou o povo");
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
    
    
}

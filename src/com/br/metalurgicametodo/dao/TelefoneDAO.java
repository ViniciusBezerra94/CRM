/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.dao;


import com.br.metalurgicametodo.entidades.Pessoa;
import com.br.metalurgicametodo.entidades.Telefone;
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
//Classe de Crud do banco de dados
public class TelefoneDAO extends DaoBase {
    Conexao conexao = new Conexao();
    
    //metodo para salvar um objeto do tipo Telefone no banco de dados
    @Override
    public void save(Object objeto) {
        Telefone telefone = (Telefone) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "insert into Telefone(codigo_pessoa,telefone,telefone_celular) values (?,?,?)";
            insereSt = con.prepareStatement(sql);
            
            //insereSt.setInt(1, id_funcionario_seq.nextVal);
            insereSt.setInt(1, telefone.getPessoa().getCodigoPessoa());
            insereSt.setString(2, telefone.getTelefoneFixo());
            insereSt.setString(3, telefone.getTelefoneCelular());
            System.out.println("Adicionou o telefone");
            insereSt.executeUpdate();

        } catch (Throwable e) {
            System.out.println("Erro ao incluir telefone. Mensagem: " + e.getMessage());
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

    
    //metodo para alterar alterar um objeto do tipo telefone salvo no banco de dados
    @Override
    public void update(Object objeto) {
        Telefone telefone = (Telefone) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "UPDATE Telefone SET telefone = ?, telefone_celular = ?   WHERE codigo_pessoa = ?";
            insereSt = con.prepareStatement(sql);
            
            insereSt.setString(1, telefone.getTelefoneFixo());
            insereSt.setString(2, telefone.getTelefoneCelular());
            insereSt.setInt(3, telefone.getPessoa().getCodigoPessoa());
            
            System.out.println("Adicionou o telefone");
            insereSt.executeUpdate();

        } catch (Throwable e) {
            System.out.println("Erro ao incluir telefone. Mensagem: " + e.getMessage());
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

    // metodo para deletar um objeto do tipo telefone no banco de dados
    @Override
    public void delete(Object objeto) {
      Telefone telefone = (Telefone) objeto;
        PreparedStatement delete = null;
        Connection con = null;
        String sql = "DELETE FROM Telefone WHERE codigo_pessoa = ?";
        try {
            con = conexao.getConexao();
            delete = con.prepareStatement(sql);
           
            
            
            delete.setInt(1, telefone.getPessoa().getCodigoPessoa());

            delete.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao incluir telefone. Mensagem: " + e.getMessage());
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

    //metodo para criar uma lista de objetos do tipo telefone atravez de telefones cadastrados no banco
    @Override
    public List list() {
       Connection con = null;
        List<Telefone> telefones = new ArrayList();
        Statement consulta = null;
        ResultSet resultado = null;
        Telefone telefone = null;

        String sql = "select * from telefone order by codigo_pessoa";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                telefone = new Telefone();
                Pessoa p = new Pessoa();
                p.setCodigoPessoa(resultado.getInt("codigo_pessoa"));
                telefone.setPessoa(p);
                telefone.setTelefoneFixo(resultado.getString("telefone"));
                telefone.setTelefoneCelular(resultado.getString("telefone_celular"));
                

                telefones.add(telefone);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de telefone. Mensagem: " + e.getMessage());
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
        return telefones;
    }
    
    //metodo para buscar telefone atravez do codigo de pessoa
    //tendo como um retorno um objeto do tipo telefone
    public Telefone buscarPorCodigoP(int codigoP)
    {
       Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        Telefone telefone = null;

        String sql = "select * from telefone where codigo_pessoa = " + codigoP;
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                telefone = new Telefone();
                Pessoa p = new Pessoa();
                PessoaDao pDAO = new PessoaDao();
                
                telefone.setPessoa(p = pDAO.buscar(codigoP));
                telefone.setTelefoneCelular(resultado.getString("telefone_celular"));
                telefone.setTelefoneFixo(resultado.getString("telefone"));
               
            }
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de Telefone. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    con.close();
                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }
        return telefone;

    }
    
}

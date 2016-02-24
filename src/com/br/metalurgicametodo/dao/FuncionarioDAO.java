/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.dao;

import com.br.metalurgicametodo.entidades.Funcionario;
import com.br.metalurgicametodo.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius
 * @param <T>
 */
//Classe de CRUD do BANCO
public class FuncionarioDAO<T> extends DaoBase {

    Conexao conexao = new Conexao();
//Metodo utilizado para salvar um  objeto Funcionario no banco de dados

    @Override
    public void save(Object objeto) {
        Funcionario funcionario = (Funcionario) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "insert into Funcionario(id_funcionario,nome, login,cargo,senha,re) values (funcionario_s.nextval,?,?,?,?,?)";
            insereSt = con.prepareStatement(sql);
            insereSt.setString(1, funcionario.getNome());
            insereSt.setString(2, funcionario.getLogin());
            insereSt.setString(3, funcionario.getCargo());
            insereSt.setString(4, funcionario.getSenha());
            insereSt.setInt(5, funcionario.getRe());
            System.out.println("Adicionou o povo");
            insereSt.executeUpdate();

        } catch (Throwable e) {
            System.out.println("Erro ao incluir funcionario. Mensagem: " + e.getMessage());
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
//Metodo utilizado para criar uma lista de Funcionario com informaçoes retiradas do banco

    @Override
    public List list() {
        Connection con = null;
        List<Funcionario> funcionario = new ArrayList();
        Statement consulta = null;
        ResultSet resultado = null;
        Funcionario funcionarios = null;

        String sql = "select * from Funcionario order by id_funcionario";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                Funcionario func = new Funcionario();
                func.setId_funcionario(new Integer(resultado.getInt("id_funcionario")));
                func.setNome(resultado.getString("nome"));
                func.setLogin(resultado.getString("login"));
                func.setCargo(resultado.getString("cargo"));
                func.setSenha(resultado.getString("senha"));
                func.setRe(resultado.getInt("re"));

                funcionario.add(func);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de funcionario. Mensagem: " + e.getMessage());
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
        return funcionario;
    }
//Metodo utilizado para deletar um  objeto Funcionario no banco de dados

    @Override
    public void delete(Object objeto) {
        Funcionario funcionario = (Funcionario) objeto;
        PreparedStatement delete = null;
        Connection con = null;
        String sql = "DELETE FROM Funcionario WHERE id_funcionario = ?";
        try {
            con = conexao.getConexao();
            delete = con.prepareStatement(sql);

            delete.setInt(1, funcionario.getId_funcionario());

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
//Metodo utilizado para alterar um  objeto Funcionario no banco de dados

    @Override
    public void update(Object objeto) {
        Funcionario funcionario = (Funcionario) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "UPDATE Funcionario SET nome = ?, login = ?, cargo = ? , senha = ? , re = ? WHERE id_funcionario = ?";
            insereSt = con.prepareStatement(sql);

            insereSt.setString(1, funcionario.getNome());
            insereSt.setString(2, funcionario.getLogin());
            insereSt.setString(3, funcionario.getCargo());
            insereSt.setString(4, funcionario.getSenha());
            insereSt.setInt(5, funcionario.getRe());
            insereSt.setInt(6, funcionario.getId_funcionario());
            System.out.println("Adicionou o povo");
            insereSt.executeUpdate();
            insereSt.close();
        } catch (Throwable e) {
            System.out.println("Erro ao incluir funcionario. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    con.close();

                }
                System.out.println("Fim conexao");
            } catch (Throwable e) {
                System.out.println("houve algum problema ao encerrar a conexão: " + e.getMessage());
            }
        }

    }

    //Metodo utilizado para buscar um funcionario no banco de dados atravez do RE
    //Tendo como retorno um funcionario

    public Funcionario buscarPorRE(int re) {
        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        Funcionario func = null;

        String sql = "select * from Funcionario where re = " + re;
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                func = new Funcionario();
                func.setCargo(resultado.getString("cargo"));
                func.setId_funcionario(resultado.getInt("id_funcionario"));
                func.setLogin(resultado.getString("login"));
                func.setNome(resultado.getString("nome"));
                func.setRe(resultado.getInt("re"));
                func.setSenha(resultado.getString("senha"));

            }
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de contato. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    con.close();
                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }
        return func;
    }

    public Funcionario buscarLogin(String login) {
        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        Funcionario func = null;

        String sql = "select * from Funcionario where login = '" + login +"'";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                func = new Funcionario();
                func.setCargo(resultado.getString("cargo"));
                func.setId_funcionario(resultado.getInt("id_funcionario"));
                func.setLogin(resultado.getString("login"));
                func.setNome(resultado.getString("nome"));
                func.setRe(resultado.getInt("re"));
                func.setSenha(resultado.getString("senha"));

            }
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de funcionario. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    con.close();
                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }
        return func;
    }
}
    


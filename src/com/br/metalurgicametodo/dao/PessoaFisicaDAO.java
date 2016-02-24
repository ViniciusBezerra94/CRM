/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.dao;

import com.br.metalurgicametodo.entidades.Pessoa;
import com.br.metalurgicametodo.entidades.PessoaFisica;
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
public class PessoaFisicaDAO extends DaoBase {

    Conexao conexao = new Conexao();
//Metodo utilizado para salvar uma pessoa fisica no banco de dados
    @Override
    public void save(Object objeto) {
        PessoaFisica pessoaF = (PessoaFisica) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "insert into pessoa_fisica(codigo_pessoa,cpf,rg,data_nascimento,sexo,estadocivil) values (?,?,?,?,?,?)";
            insereSt = con.prepareStatement(sql);

            //insereSt.setInt(1, id_funcionario_seq.nextVal);
            insereSt.setInt(1, pessoaF.getPessoa().getCodigoPessoa());
            insereSt.setString(2, pessoaF.getCpf());
            insereSt.setString(3, pessoaF.getRg());
            insereSt.setDate(4, pessoaF.getDataNascimento());
            insereSt.setString(5, pessoaF.getSexo());
            
            insereSt.setString(6, pessoaF.getEstadoCivil());

            System.out.println("Adicionou o povo");
            insereSt.executeUpdate();
            insereSt.close();
        } catch (Throwable e) {
            System.out.println("Erro ao incluir pessoa. Mensagem: " + e.getMessage());
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

    //Metodo utilizado para deletar uma pessoa fisica no banco de dados
    @Override
    public void delete(Object objeto) {
        PessoaFisica pessoaF = (PessoaFisica) objeto;
        PreparedStatement delete = null;
        Connection con = null;
        String sql = "DELETE FROM pessoa_fisica WHERE codigo_pessoa = ?";
        try {
            con = conexao.getConexao();
            delete = con.prepareStatement(sql);

            delete.setInt(1, pessoaF.getPessoa().getCodigoPessoa());

            delete.executeUpdate();
            delete.close();
        } catch (SQLException e) {
            System.out.println("Erro ao incluir contato. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    con.close();
                }
            } catch (Throwable f) {
                System.out.println("Erro ao tentar fechar conexao. Mensagem: " + f.getMessage());
            }

        }
    }

    //Metodo utilizado para alterar uma pessoa fisica no banco de dados
    @Override
    public void update(Object objeto) {
        PessoaFisica pessoaF = (PessoaFisica) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "UPDATE pessoa_fisica SET cpf = ?, rg = ? , data_nascimento = ?, sexo = ?, estadocivil = ? WHERE codigo_pessoa = ?";
            insereSt = con.prepareStatement(sql);

            insereSt.setString(1, pessoaF.getCpf());
            insereSt.setString(2, pessoaF.getRg());
            insereSt.setDate(3, (java.sql.Date) pessoaF.getDataNascimento());
            insereSt.setString(4, pessoaF.getSexo());
            
            insereSt.setString(5, pessoaF.getEstadoCivil());
            insereSt.setInt(6, pessoaF.getPessoa().getCodigoPessoa());
            System.out.println("Alterou o povo");
            insereSt.executeUpdate();
            insereSt.close();
        } catch (Throwable e) {
            System.out.println("Erro ao incluir contato. Mensagem: " + e.getMessage());
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

    //Metodo utilizado para criar uma lista de objetos de pessoas fisicas atravez de informações banco de dados
    @Override
    public List list() {
        Connection con = null;
        List<PessoaFisica> pessoasFisicas = new ArrayList();
        Statement consulta = null;
        ResultSet resultado = null;
        PessoaFisica pessoaF = null;

        String sql = "select * from Pessoa_Fisica order by codigo_pessoa";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                pessoaF = new PessoaFisica();
                Pessoa p = new Pessoa();
                p.setCodigoPessoa(resultado.getInt("codigo_pessoa"));
                pessoaF.setPessoa(p);
                pessoaF.setCpf(resultado.getString("cpf"));
                pessoaF.setRg(resultado.getString("rg"));
                pessoaF.setDataNascimento(resultado.getDate("data_nascimento"));
                pessoaF.setSexo(resultado.getString("sexo"));
                
                pessoaF.setEstadoCivil(resultado.getString("estadocivil"));

                pessoasFisicas.add(pessoaF);
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
        return pessoasFisicas;
    }
//Metodo utilizado para buscar uma pessoa fisica no banco de dados tendo como parametro seu cpf
    public PessoaFisica buscarCPF(String cpf) {
        PessoaFisica pessoaF = null;
        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        Pessoa pessoa = null;

        String sql = "select * from Pessoa_Fisica where CPF = " + "'"+ cpf +"'";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                pessoaF = new PessoaFisica();
                Pessoa p = new Pessoa();
                PessoaDao pDao = new PessoaDao();
                p = pDao.buscar(resultado.getInt("codigo_pessoa"));
                pessoaF.setPessoa(p);
                pessoaF.setCpf(resultado.getString("CPF"));
                pessoaF.setRg(resultado.getString("RG"));
                pessoaF.setDataNascimento(resultado.getDate("DATA_NASCIMENTO"));     
                pessoaF.setEstadoCivil(resultado.getString("estadocivil"));
                pessoaF.setSexo(resultado.getString("sexo"));
                

            }
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de PessoaFisica. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    con.close();
                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }

        return pessoaF;
    }
//Metodo utilizado para buscar uma pessoa fisica no banco de dados atravez do seu ID
    public PessoaFisica buscarPorID(int id) {
        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        PessoaFisica pessoaF = null;

        String sql = "select * from Pessoa_Fisica where codigo_pessoa = " + id;
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                pessoaF = new PessoaFisica();
                pessoaF.setDataNascimento(resultado.getDate("data_nascimento"));
                pessoaF.setRg(resultado.getString("rg"));
                pessoaF.setCpf(resultado.getString("CPF"));
                Pessoa p = new Pessoa();
                p.setCodigoPessoa(resultado.getInt("codigo_pessoa"));
                pessoaF.setPessoa(p);
                pessoaF.setSexo(resultado.getString("sexo"));
               
                pessoaF.setEstadoCivil(resultado.getString("estadocivil"));

            }
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de Pessoa Fisica. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    con.close();
                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }
        return pessoaF;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.dao;

import com.br.metalurgicametodo.entidades.Pessoa;
import com.br.metalurgicametodo.entidades.PessoaJuridica;
import com.br.metalurgicametodo.conexao.Conexao;
import com.br.metalurgicametodo.entidades.PessoaFisica;
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
public class PessoaJuridicaDAO extends DaoBase {

    Conexao conexao = new Conexao();

//Metodo utilizado para salvar uma pessoa juridica no banco de dados passando um objeto de PessoaJuridica como parametro
    @Override
    public void save(Object objeto) {
        PessoaJuridica pessoaJ = (PessoaJuridica) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "insert into pessoa_juridica(codigo_pessoa,cnpj,nome_fantasia,razao_social) values (?,?,?,?)";
            insereSt = con.prepareStatement(sql);

            //insereSt.setInt(1, id_funcionario_seq.nextVal);
            insereSt.setInt(1, pessoaJ.getPessoa().getCodigoPessoa());
            insereSt.setString(2, pessoaJ.getCnpj());
            insereSt.setString(3, pessoaJ.getNomeFantasia());
            insereSt.setString(4, pessoaJ.getRazaoSocial());
            System.out.println("Adicionou o pessoaJuridica");
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

    //Metodo utilizado para deletar uma pessoa juridica no banco de dados passando um objeto de PessoaJuridica como parametro
    @Override
    public void delete(Object objeto) {
        PessoaJuridica pessoaJ = (PessoaJuridica) objeto;
        PreparedStatement delete = null;
        Connection con = null;
        String sql = "DELETE FROM pessoa_juridica WHERE codigo_pessoa = ?";
        try {
            con = conexao.getConexao();
            delete = con.prepareStatement(sql);

            delete.setInt(1, pessoaJ.getPessoa().getCodigoPessoa());

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
//Metodo utilizado para alterar uma pessoa juridica no banco de dados passando um objeto de PessoaJuridica como parametro
    @Override
    public void update(Object objeto) {
        PessoaJuridica pessoaJ = (PessoaJuridica) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "UPDATE pessoa_juridica SET  cnpj = ? , nome_fantasia = ? , razao_social = ?  WHERE codigo_pessoa = ?";
            insereSt = con.prepareStatement(sql);

            insereSt.setString(1, pessoaJ.getCnpj());
            insereSt.setString(2, pessoaJ.getNomeFantasia());
            insereSt.setString(3, pessoaJ.getRazaoSocial());
            insereSt.setInt(4, pessoaJ.getPessoa().getCodigoPessoa());
            System.out.println("Adicionou a pessoa Juridica");
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
//Metodo utilizado para criar uma lista de objetos de Pessoas Juridicas que estão cadastradas no banco
    @Override
    public List list() {
        Connection con = null;
        List<PessoaJuridica> pessoasJuridicas = new ArrayList();
        Statement consulta = null;
        ResultSet resultado = null;
        PessoaJuridica pessoaJ = null;

        String sql = "select * from pessoa_juridica order by codigo_pessoa";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                pessoaJ = new PessoaJuridica();
                Pessoa p = new Pessoa();
                p.setCodigoPessoa(resultado.getInt("codigo_pessoa"));
                pessoaJ.setPessoa(p);
                pessoaJ.setCnpj(resultado.getString("cnpj"));
                pessoaJ.setNomeFantasia(resultado.getString("nome_fantasia"));
                pessoaJ.setRazaoSocial(resultado.getString("razao_social"));

                pessoasJuridicas.add(pessoaJ);
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
        return pessoasJuridicas;
    }
// metodo utilizado para buscar uma pessoa juridica no banco atravez de seu CNPJ
// tendo como retorno um objeto de pessoa juridica
    public PessoaJuridica buscarCNPJ(String cnpj) {
        PessoaJuridica pessoaJ = null;
        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        Pessoa pessoa = null;

        String sql = "select * from Pessoa_Juridica where CNPJ = '" + cnpj + "'";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                pessoaJ = new PessoaJuridica();
                Pessoa p = new Pessoa();
                PessoaDao pDao = new PessoaDao();
                p = pDao.buscar(resultado.getInt("codigo_pessoa"));
                pessoaJ.setPessoa(p);
                pessoaJ.setCnpj(resultado.getString("CNPJ"));
                pessoaJ.setNomeFantasia(resultado.getString("Nome_Fantasia"));
                pessoaJ.setRazaoSocial(resultado.getString("Razao_Social"));

            }
            resultado.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de PessoaFisica. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    consulta.close();

                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }

        return pessoaJ;

    }
// metodo utilizado para buscar uma pessoa juridica no banco atravez de seu ID
// tendo como retorno um objeto de pessoa juridica
    public PessoaJuridica buscarPorID(int id) {
        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        PessoaJuridica pessoaJ = null;

        String sql = "select * from Pessoa_Juridica where codigo_pessoa = " + id;
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                pessoaJ = new PessoaJuridica();
                pessoaJ.setCnpj(resultado.getString("CNPJ"));
                pessoaJ.setNomeFantasia(resultado.getString("nome_fantasia"));
                pessoaJ.setRazaoSocial(resultado.getString("razao_social"));
                Pessoa p = new Pessoa();
                p.setCodigoPessoa(resultado.getInt("codigo_pessoa"));
                pessoaJ.setPessoa(p);

            }
            resultado.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de Pessoa Fisica. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {
                    consulta.close();

                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }
        return pessoaJ;

    }

}

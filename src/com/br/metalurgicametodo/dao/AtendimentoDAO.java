/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.dao;

import com.br.metalurgicametodo.entidades.Atendimento;
import com.br.metalurgicametodo.entidades.Pessoa;
import com.br.metalurgicametodo.entidades.Venda;
import com.br.metalurgicametodo.conexao.Conexao;
import com.br.metalurgicametodo.entidades.PessoaFisica;
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

//Classe de CRUD do banco
public class AtendimentoDAO extends DaoBase {

    Conexao conexao = new Conexao();
//Metodo utilizado para salvar um  objeto Atendimento no banco de dados
    @Override
    public void save(Object objeto) {
        Atendimento atendimento = (Atendimento) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "insert into Atendimento(protocolo,tipo_de_contato,data_do_contato,descricao,codigo_pessoa,codigo_venda,tipo_assunto,motivo,solucao,status ) values (protocolo_seq.nextval,?,?,?,?,?,?,?,?,?)";
            insereSt = con.prepareStatement(sql);
            insereSt.setString(1, atendimento.getTipoContato());
            insereSt.setDate(2, (Date) atendimento.getDataContato());
            insereSt.setString(3, atendimento.getDescricao());
            insereSt.setInt(4, atendimento.getPessoa().getCodigoPessoa());
            insereSt.setInt(5, atendimento.getVenda().getCodigoVenda());
            insereSt.setString(6, atendimento.getTipoAssunto());
            insereSt.setString(7, atendimento.getMotivo());
            insereSt.setString(8, atendimento.getSolucao());
            insereSt.setString(9, atendimento.getStatus());

            insereSt.executeUpdate();
            insereSt.close();
            System.out.println("Adicionou o atendimento");
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

    @Override
    public void delete(Object objeto) {
        Atendimento atendimento = (Atendimento) objeto;
        PreparedStatement delete = null;
        Connection con = null;
        String sql = "DELETE FROM Atendimento WHERE protocolo = ?";
        try {
            con = conexao.getConexao();
            delete = con.prepareStatement(sql);

            delete.setInt(1, atendimento.getProtocolo());

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

    @Override
    //Metodo utilizado para colocar os Atendimentos em uma lista com informaçoes adquiridas do banco de dados
    public List list() {
        Connection con = null;
        List<Atendimento> atendimento = new ArrayList();
        Statement consulta = null;
        ResultSet resultado = null;
        Atendimento atendimentos = null;

        String sql = "select * from Atendimento order by protocolo";
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                Atendimento atend = new Atendimento();
                atend.setProtocolo(new Integer(resultado.getInt("protocolo")));
                atend.setTipoContato(resultado.getString("TIPO_DE_CONTATO"));
                atend.setDataContato(resultado.getDate("Data_do_contato"));
                Pessoa pessoa = new Pessoa();
                pessoa.setCodigoPessoa(resultado.getInt("codigo_pessoa"));
                atend.setPessoa(pessoa);
                Venda venda = new Venda();
                venda.setCodigoVenda(resultado.getInt("codigo_venda"));
                atend.setVenda(venda);
                atend.setTipoAssunto(resultado.getString("tipo_assunto"));
                atend.setMotivo(resultado.getString("motivo"));
                atend.setSolucao(resultado.getString("solucao"));
                atend.setStatus(resultado.getString("status"));

                atendimento.add(atend);
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
        return atendimento; //To change body of generated methods, choose Tools | Templates.
    }
//Metodo utilizado para alterar um Atendimento no banco de dados
    @Override
    public void update(Object objeto) {
        Atendimento atendimento = (Atendimento) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "UPDATE Atendimento SET tipo_de_contato = ?, data_do_contato = ?, descricao = ? , codigo_pessoa = ? , codigo_venda = ?, tipo_assunto = ? , motivo = ?, solucao = ?, status = ? WHERE protocolo = ?";
            insereSt = con.prepareStatement(sql);

            insereSt.setString(1, atendimento.getTipoContato());
            insereSt.setDate(2, (Date) atendimento.getDataContato());
            insereSt.setString(3, atendimento.getDescricao());
            insereSt.setInt(4, atendimento.getPessoa().getCodigoPessoa());
            insereSt.setObject(5, (Venda) atendimento.getVenda());

            insereSt.setString(6, atendimento.getTipoAssunto());
            insereSt.setString(7, atendimento.getMotivo());
            insereSt.setInt(8, atendimento.getProtocolo());
            insereSt.setString(9, atendimento.getSolucao());
            insereSt.setString(10, atendimento.getStatus());
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
//Metodo utilizado para buscar o ultimo protocolo inserido no banco de dados
//Tendo como retorno so o numero de protocolo.
    public int buscarCH() {

        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        int protocolo = 0;

        String sql = "select max(protocolo) as protocolo from atendimento ";

        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {

                protocolo = resultado.getInt("protocolo");

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
        return protocolo;
    }
//Metodo utilizado para buscar um atendimento atravez do numero de protocolo
// retorna um atendimento
    public Atendimento buscarProtocolo(int protocolo) {

        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        Pessoa pessoa = null;
        Atendimento atend = null;
        String sql = "select * from atendimento where protocolo =  " + protocolo;
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);

            while (resultado.next()) {
               
                atend = new Atendimento();
                atend.setDataContato(resultado.getDate("data_do_contato"));
                atend.setDescricao(resultado.getString("descricao"));
                atend.setMotivo(resultado.getString("motivo"));
                pessoa = new Pessoa();
                pessoa.setCodigoPessoa(resultado.getInt("codigo_pessoa"));

                atend.setPessoa(pessoa);
                atend.setProtocolo(resultado.getInt("protocolo"));
                atend.setSolucao(resultado.getString("solucao"));
                atend.setStatus(resultado.getString("status"));
                atend.setTipoAssunto(resultado.getString("tipo_assunto"));
                atend.setTipoContato(resultado.getString("tipo_de_contato"));
                Venda venda = new Venda();
                venda.setCodigoVenda(resultado.getInt("codigo_venda"));
                atend.setVenda(venda);


            }
                consulta.close();
                resultado.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar codigo de Atendimento. Mensagem: " + e.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {

                    con.close();
                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
            }
        }

        return atend;
    }
    //Metodo utilizado para criar uma lista indo pegar no banco Atendimentos atravez do codigo de pessoa
     public List listPorCodigoP(int codigoP) {
        Connection con = null;
        List<Atendimento> atendimento = new ArrayList();
        Statement consulta = null;
        ResultSet resultado = null;
        Atendimento atendimentos = null;

        String sql = "select * from Atendimento where codigo_pessoa = " + codigoP;
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                Atendimento atend = new Atendimento();
                atend.setProtocolo(new Integer(resultado.getInt("protocolo")));
                atend.setTipoContato(resultado.getString("TIPO_DE_CONTATO"));
                atend.setDataContato(resultado.getDate("Data_do_contato"));
                Pessoa pessoa = new Pessoa();
                pessoa.setCodigoPessoa(resultado.getInt("codigo_pessoa"));
                atend.setPessoa(pessoa);
                Venda venda = new Venda();
                venda.setCodigoVenda(resultado.getInt("codigo_venda"));
                atend.setVenda(venda);
                atend.setTipoAssunto(resultado.getString("tipo_assunto"));
                atend.setMotivo(resultado.getString("motivo"));
                atend.setSolucao(resultado.getString("solucao"));
                atend.setStatus(resultado.getString("status"));

                atendimento.add(atend);
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
        return atendimento; //To change body of generated methods, choose Tools | Templates.
    }
}

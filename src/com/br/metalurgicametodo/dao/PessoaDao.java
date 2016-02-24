package com.br.metalurgicametodo.dao;

import com.br.metalurgicametodo.entidades.Funcionario;
import com.br.metalurgicametodo.entidades.Pessoa;
import com.br.metalurgicametodo.entidades.PessoaFisica;
import com.br.metalurgicametodo.entidades.Produto;
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

//Classe de CRUD banco de dados
public class PessoaDao<T> extends DaoBase implements IPessoaDao {

    Conexao conexao = new Conexao();



//Metodo utilizado para alterar um objeto pessoa no banco de dados    


    @Override
    public void update(Object objeto) {
        Pessoa pessoa = (Pessoa) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "UPDATE pessoa SET nome = ?, tipo_pessoa = ? ,cep = ?, rua = ? , bairro = ? ,cidade = ? , uf = ?, numero = ?, email = ? where codigo_pessoa = ?";
            insereSt = con.prepareStatement(sql);

            insereSt.setString(1, pessoa.getNome());
            insereSt.setString(2, pessoa.getTipoPessoa());
            insereSt.setString(3, pessoa.getCep());
            insereSt.setString(4, pessoa.getRua());
            insereSt.setString(5, pessoa.getBairro());
            insereSt.setString(6, pessoa.getCidade());

            insereSt.setString(7, pessoa.getUf());
            insereSt.setInt(8, pessoa.getNumero());
            insereSt.setString(9, pessoa.getEmail());
            insereSt.setInt(10, pessoa.getCodigoPessoa());

            insereSt.executeUpdate();

            insereSt.close();
            System.out.println("Alterou o povo");
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

    //Metodo utilizado para salvar um objeto pessoa no banco de dados    
    @Override
    public void save(Object objeto) {
        Pessoa pessoa = (Pessoa) objeto;
        PreparedStatement insereSt = null;
        Connection con = null;
        try {
            con = conexao.getConexao();

            String sql = "insert into Pessoa(codigo_pessoa,nome,tipo_pessoa,cep,rua,bairro,cidade,uf,numero,email) values (pessoa_seq.nextval,?,?,?,?,?,?,?,?,?)";
            insereSt = con.prepareStatement(sql);

            insereSt.setString(1, pessoa.getNome());
            insereSt.setString(2, pessoa.getTipoPessoa());
            insereSt.setString(3, pessoa.getCep());
            insereSt.setString(4, pessoa.getRua());
            insereSt.setString(5, pessoa.getBairro());
            insereSt.setString(6, pessoa.getCidade());
            insereSt.setString(7, pessoa.getUf());
            insereSt.setInt(8, pessoa.getNumero());
            insereSt.setString(9, pessoa.getEmail());

            System.out.println("Adicionou a pessoa");
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
//Metodo utilizado para criar uma lista de objetos de pessoas no banco de dados    
    @Override
    public List<T> listarPorCpf(String cpf) {
        try {
            Connection c = conexao.getConexao();

            List<PessoaFisica> contatos = new ArrayList<PessoaFisica>();
            Statement consulta = null;
            ResultSet resultado = null;
            PessoaFisica contato = null;

            String sql = "select * from Pessoa";
            try {
                consulta = c.createStatement();
                resultado = consulta.executeQuery(sql);
                while (resultado.next()) {
                    contato = new PessoaFisica();
                    contato.setCpf(String.valueOf(resultado.getObject("codigo")));
                    contato.setDataNascimento(resultado.getDate("nome"));
                    contato.setRg(String.valueOf(resultado.getString("telefone")));

                    contatos.add(contato);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao buscar codigo de contato. Mensagem: " + e.getMessage());
            } finally {
                try {
                    consulta.close();
                    resultado.close();
                    c.close();
                } catch (Throwable e) {
                    System.out.println("Erro ao fechar operaçoes de consulta. Mensagem: " + e.getMessage());
                }
            }
            return null;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
//Metodo utilizado para buscar um pessoa no banco de dados atravez de seu ID
    //tendo como retorno um objeto to tipo pessoa
    public Pessoa buscar(int id) {
        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        Pessoa pessoa = null;

        String sql = "select * from Pessoa where codigo_pessoa = " + id;
        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                Pessoa pess = new Pessoa();
                pess.setBairro(resultado.getString("Bairro"));
                pess.setCep(resultado.getString("CEP"));
                pess.setCidade(resultado.getString("Cidade"));
                pess.setCodigoPessoa(resultado.getInt("codigo_pessoa"));
                pess.setNome(resultado.getString("nome"));
                pess.setNumero(resultado.getInt("numero"));
                pess.setRua(resultado.getString("Rua"));
                pess.setTipoPessoa(resultado.getString("TIPO_PESSOA"));
                pess.setUf(resultado.getString("UF"));
                pess.setEmail(resultado.getString("email"));
                pessoa = pess;

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
        return pessoa;

    }

    
    //Metodo para buscar o codigo da ultima pessoa inserida no banco de dados
    public Pessoa buscarUltimaP() {
        Connection con = null;

        Statement consulta = null;
        ResultSet resultado = null;
        Pessoa pessoa = null;

        String sql = "select max(codigo_pessoa) as codigo_pessoa from pessoa ";

        try {
            con = conexao.getConexao();
            consulta = con.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {
                pessoa = new Pessoa();
                pessoa.setCodigoPessoa(resultado.getInt("codigo_pessoa"));
                
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
        return pessoa;
    }
}


package com.br.metalurgicametodo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// Classe que gera conexão com o banco de dados da ORACLE
public class Conexao {

    static String driver = "oracle.jdbc.driver.OracleDriver";
    static String banco = "xe";
    static String caminhoLocal = "conexao com o banco" + banco;
    static String caminhoRemoto = "conexao com o banco" + banco;
    static String usuario = "pap";
    static String senha = "pap";
    static Connection conexao = null;


    public Connection getConexao() throws SQLException {

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(caminhoLocal, usuario, senha);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Falha no Banco de Dados\n" + erro.toString());
        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado\n" + erro.toString());
        }
        return conexao;
    }

}

package com.br.metalurgicametodo.relatorio;

import com.br.metalurgicametodo.conexao.Conexao;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import org.apache.tools.ant.taskdefs.rmic.KaffeRmic;


public class Relatorio {

    public void gerarRelatorioVendas() throws SQLException {
        Conexao conexao = new Conexao();
        
        //Pega o local do arquivo .jasper no pacote do projeto.
        InputStream is = getClass().getResourceAsStream("relatorioVendas.jasper");
        try {
            //Através da conexão, gera o relatorio com os dados no banco.
            JasperPrint imprimir = JasperFillManager.fillReport(is, null, conexao.getConexao());
            //Mostra na tela o resultado do relatório.
            JasperViewer visualizar = new JasperViewer(imprimir, false);
            //Habilita a tela.
            visualizar.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório");
        }

    }

    public void gerarRelatorioProdutos() throws SQLException {
        Conexao conexao = new Conexao();
        InputStream is = getClass().getResourceAsStream("relatorioProdutos.jasper");
        try {
            JasperPrint imprimir = JasperFillManager.fillReport(is, null, conexao.getConexao());
            JasperViewer visualizar = new JasperViewer(imprimir, false);
            visualizar.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório");
        }

    }

    public void gerarRelatorioClientes() throws SQLException {
        Conexao conexao = new Conexao();
        InputStream is = getClass().getResourceAsStream("relatorioClientes.jasper");
        try {
            JasperPrint imprimir = JasperFillManager.fillReport(is, null, conexao.getConexao());
            JasperViewer visualizar = new JasperViewer(imprimir, false);
            visualizar.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório");
        }
    }

    public void gerarGraficoPizza() throws SQLException {
        Conexao conexao = new Conexao();
        InputStream is = getClass().getResourceAsStream("graficoPizza.jasper");
        try {
            JasperPrint imprimir = JasperFillManager.fillReport(is, null, conexao.getConexao());
            JasperViewer visualizar = new JasperViewer(imprimir, false);
            visualizar.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório");
        }

    }

    public void gerarGraficoBarra() throws SQLException {
        Conexao conexao = new Conexao();
       InputStream is = getClass().getResourceAsStream("graficoBarra.jasper");
        try {
            JasperPrint imprimir = JasperFillManager.fillReport(is, null, conexao.getConexao());
            JasperViewer visualizar = new JasperViewer(imprimir, false);
            visualizar.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório");
        }
    }
}

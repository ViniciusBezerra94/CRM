/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.swing;

import com.br.metalurgicametodo.dao.AtendimentoDAO;
import com.br.metalurgicametodo.dao.PessoaFisicaDAO;
import com.br.metalurgicametodo.dao.PessoaJuridicaDAO;
import com.br.metalurgicametodo.entidades.Atendimento;
import com.br.metalurgicametodo.entidades.PessoaFisica;
import com.br.metalurgicametodo.entidades.PessoaJuridica;
import com.br.metalurgicametodo.grid.GridProtocolo;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Vinicius
 */
//Classe para consulta de atendimento
public class Tela_ConsultaAtendimento extends javax.swing.JInternalFrame {

    /**
     * Creates new form Tela_ConsultaAtendimento
     */
    public Tela_ConsultaAtendimento() {

        initComponents();

        /*   
         Atendimento atendimento = null;
         GridProtocolo gridP = null;
         AtendimentoDAO atenDAO = new AtendimentoDAO();
         DefaultTableModel grid = (DefaultTableModel) tabela.getModel();
         for (int i = 0; i < atenDAO.list().size(); i++) {
         atendimento = new Atendimento();
         gridP = new GridProtocolo();
         atendimento = (Atendimento) atenDAO.list().get(i);
         grid.addRow(gridP.carregarGridProtocolo(atendimento));
        
         }
         */
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    public int selecionada;
    public static String protocolo;
    public static String tipoDec;
    public static String nome;
    public static String data;
    public static String status;
    public static String assunto;
    public static String motivo;
    public static String comentario;
    public static String solucao;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroupBuscarPor = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rdProtocolo = new javax.swing.JRadioButton();
        rdCPF = new javax.swing.JRadioButton();
        rdCNPJ = new javax.swing.JRadioButton();
        btnVisualizar = new javax.swing.JButton();
        txt_cpf = new javax.swing.JFormattedTextField();
        jftCNPJ = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        jftProtocolo = new javax.swing.JFormattedTextField();

        setClosable(true);
        setTitle("Consultar Atendimento");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Protocolo", "Nome", "CPF / CNPJ", "Data do Chamado", "Assunto", "Motivo", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);

        jLabel1.setText("Buscar por:");

        btngroupBuscarPor.add(rdProtocolo);
        rdProtocolo.setText("Protocolo");
        rdProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdProtocoloActionPerformed(evt);
            }
        });

        btngroupBuscarPor.add(rdCPF);
        rdCPF.setText("CPF");
        rdCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCPFActionPerformed(evt);
            }
        });

        btngroupBuscarPor.add(rdCNPJ);
        rdCNPJ.setText("CNPJ");
        rdCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCNPJActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        MaskFormatter mascaraCpf = null;
        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascaraCpf = new MaskFormatter("###.###.###-##")));
            mascaraCpf.setPlaceholderCharacter('_');
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.setEnabled(false);

        MaskFormatter mascaraCnpj = null;
        try {
            jftCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascaraCnpj = new MaskFormatter("##.###.###/####-##")));
            mascaraCnpj.setPlaceholderCharacter('_');
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCNPJ.setEnabled(false);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        MaskFormatter mascaraProtocolo = null;
        try {
            jftProtocolo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory( mascaraProtocolo = new MaskFormatter("########")));
            mascaraProtocolo.setPlaceholderCharacter('_');
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftProtocolo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdProtocolo)
                            .addComponent(rdCPF)
                            .addComponent(rdCNPJ))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jftCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(txt_cpf)
                            .addComponent(jftProtocolo))
                        .addGap(54, 54, 54)
                        .addComponent(btnBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVisualizar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdProtocolo)
                    .addComponent(jftProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdCPF)
                    .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdCNPJ)
                    .addComponent(jftCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVisualizar)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        selecionada = tabela.getSelectedRow();
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            System.out.println("" + tabela.getRowCount());
            //verifica se não tem nenhuma linha selecionada
            if (tabela.getRowCount() > 0) {
                if (selecionada == -1) {
                    JOptionPane.showMessageDialog(null, "Não Selecionou nenhuma linha");
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                } else {
                    // pega valores da linha seleciona e atribui a variaveis global.
                    protocolo = String.valueOf(tabela.getValueAt(selecionada, 0));
                    nome = String.valueOf(tabela.getValueAt(selecionada, 1));
                    tipoDec = String.valueOf(tabela.getValueAt(selecionada, 2));
                    data = String.valueOf(tabela.getValueAt(selecionada, 3));
                    assunto = String.valueOf(tabela.getValueAt(selecionada, 4));
                    motivo = String.valueOf(tabela.getValueAt(selecionada, 5));
                    status = String.valueOf(tabela.getValueAt(selecionada, 6));
                    AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
                    Atendimento atend = new Atendimento();
                    //busca atendimento atraves de um protocolo
                    atend = atendimentoDAO.buscarProtocolo(Integer.parseInt(protocolo));
                    comentario = atend.getDescricao();
                    solucao = atend.getSolucao();

                    //abre uma interface swing para visualizar o atendimento
                    Tela_VisualizarAtendimento tva = new Tela_VisualizarAtendimento();
                    Tela_Principal.jdp_principal.add(tva);
                    tva.setVisible(true);
                    tva.setPosicao();
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                }
            } else {
                JOptionPane.showMessageDialog(null, "Por Favor realize uma busca");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao visualizar linha");
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));


    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        DefaultTableModel grid = (DefaultTableModel) tabela.getModel();
        grid.setNumRows(0);
        try {
            //verifica se o radio butão esta selecionado
            if (rdCPF.isSelected()) {
                //verifica se o cpf não esta vazio
                if (!txt_cpf.getText().substring(0, 1).equals("_")) {
                    //busca uma pessoa fisica no banco pelo seu cpf
                    PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
                    PessoaFisica pessoaFisica = new PessoaFisica();
                    pessoaFisica = pessoaFisicaDAO.buscarCPF(txt_cpf.getText());
                    // verifica se o objeto dessa pessoa não esta vazio
                    if (pessoaFisica != null) {
                        Atendimento atendimento = null;
                        GridProtocolo gridP = null;
                        AtendimentoDAO atenDAO = new AtendimentoDAO();
                        // cria uma lista de atendimento referente aquela pessoa fisica atravez do codigo de pessoa
                        for (int i = 0; i < atenDAO.listPorCodigoP(pessoaFisica.getPessoa().getCodigoPessoa()).size(); i++) {
                            atendimento = new Atendimento();
                            gridP = new GridProtocolo();
                            // com a ajuda do for retiro um por um atendimento da lista e coloco dentro de um objeto atendimento
                            atendimento = (Atendimento) atenDAO.listPorCodigoP(pessoaFisica.getPessoa().getCodigoPessoa()).get(i);
                            // carrega uma grid de atendimento
                            grid.addRow(gridP.carregarGridProtocolo(atendimento));

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "CPF não encontrado!!");
                    }
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor insira um CPF!");
                }
                //verifica se o botão radio de cnpj esta selecionado
            } else if (rdCNPJ.isSelected()) {
                //verifico se o campo de texto cnpj não esta vazio
                if (!jftCNPJ.getText().substring(0, 1).equals("_")) {
                    PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
                    PessoaJuridica pessoaJuridica = new PessoaJuridica();
                    //busco uma pessoa juridica atravez do campo CNPJ
                    pessoaJuridica = pessoaJuridicaDAO.buscarCNPJ(jftCNPJ.getText());
                    // verifico se esse objeto de pessoa juridica não está vazio
                    if (pessoaJuridica != null) {
                        Atendimento atendimento = null;
                        GridProtocolo gridP = null;
                        AtendimentoDAO atenDAO = new AtendimentoDAO();

                        for (int i = 0; i < atenDAO.listPorCodigoP(pessoaJuridica.getPessoa().getCodigoPessoa()).size(); i++) {
                            atendimento = new Atendimento();
                            gridP = new GridProtocolo();
                            atendimento = (Atendimento) atenDAO.listPorCodigoP(pessoaJuridica.getPessoa().getCodigoPessoa()).get(i);
                            System.out.println("Atendimento pj: " + atendimento);
                            //carrego uma grid de atendimento
                            grid.addRow(gridP.carregarGridProtocolo(atendimento));

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "CNPJ não encontrado!!!!");
                    }
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor insira um CNPJ");
                }
                //verifico se o butao de radio esta vazio
            } else if (rdProtocolo.isSelected()) {
                // verifica se o campo de texto protocolo esta vazio
                if (!jftProtocolo.getText().substring(0, 1).equals("_")) {
                    Atendimento atendimento = new Atendimento();

                    GridProtocolo gridP = new GridProtocolo();
                    AtendimentoDAO atenDAO = new AtendimentoDAO();
                    //busco um atendimento pelo protocolo
                    atendimento = atenDAO.buscarProtocolo(Integer.parseInt(jftProtocolo.getText()));
                    //verifica se o objeto atendimento não esta vazio
                    if (atendimento != null) {
                        System.out.println("" + atendimento);
                        // carrego uma grid de atendimento
                        grid.addRow(gridP.carregarGridProtocolo(atendimento));
                    } else {
                        JOptionPane.showMessageDialog(null, "Protocolo não encontrado");
                    }
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                } else {
                    JOptionPane.showMessageDialog(null, "Por Favor insira um protocolo");
                }
            } else if (!rdProtocolo.isSelected() && !rdCNPJ.isSelected() && !rdCPF.isSelected()) {
                JOptionPane.showMessageDialog(null, "Por favor selecione algum filtro de busca!!!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar atendimento");
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void rdCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCPFActionPerformed
        jftCNPJ.setEnabled(false);
        jftProtocolo.setEnabled(false);
        txt_cpf.setEnabled(true);
        txt_cpf.setText("");
        jftCNPJ.setText("");
        jftProtocolo.setText("");
    }//GEN-LAST:event_rdCPFActionPerformed

    private void rdProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdProtocoloActionPerformed
        jftCNPJ.setEnabled(false);
        jftProtocolo.setEnabled(true);
        txt_cpf.setEnabled(false);
        txt_cpf.setText("");
        jftCNPJ.setText("");
        jftProtocolo.setText("");
    }//GEN-LAST:event_rdProtocoloActionPerformed

    private void rdCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCNPJActionPerformed
        jftCNPJ.setEnabled(true);
        jftProtocolo.setEnabled(false);
        txt_cpf.setEnabled(false);
        txt_cpf.setText("");
        jftCNPJ.setText("");
        jftProtocolo.setText("");
    }//GEN-LAST:event_rdCNPJActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.ButtonGroup btngroupBuscarPor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jftCNPJ;
    private javax.swing.JFormattedTextField jftProtocolo;
    private javax.swing.JRadioButton rdCNPJ;
    private javax.swing.JRadioButton rdCPF;
    private javax.swing.JRadioButton rdProtocolo;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField txt_cpf;
    // End of variables declaration//GEN-END:variables
}

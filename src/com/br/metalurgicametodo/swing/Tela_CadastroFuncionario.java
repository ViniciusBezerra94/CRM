/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.swing;

import com.br.metalurgicametodo.dao.FuncionarioDAO;
import com.br.metalurgicametodo.dao.IDaoBase;
import com.br.metalurgicametodo.entidades.Funcionario;
import java.awt.Cursor;
import java.awt.Dimension;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author rds_d
 */
//Classe responsavel por cadastrar Funcionario
public class Tela_CadastroFuncionario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Tela_CadastroFuncionario
     */
    public Tela_CadastroFuncionario() {
        initComponents();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        lbl_nome1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbl_email1 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lbl_senha2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lbl_re = new javax.swing.JLabel();
        txtRe = new javax.swing.JFormattedTextField();
        lbl_confirmeSenha2 = new javax.swing.JLabel();
        txtSenhaConf = new javax.swing.JPasswordField();
        lbl_email2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastrar Funcionario");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Funcionario"));

        lbl_nome1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_nome1.setText("Nome :");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lbl_email1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_email1.setText("Login:");

        lbl_senha2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_senha2.setText("Senha:");

        lbl_re.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_re.setText("RE:");

        try {
            txtRe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbl_confirmeSenha2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_confirmeSenha2.setText("Confirme a Senha:");

        txtSenhaConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaConfActionPerformed(evt);
            }
        });

        lbl_email2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_email2.setText("Cargo:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_senha2)
                    .addComponent(lbl_nome1)
                    .addComponent(lbl_email1))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome)
                    .addComponent(txtSenha)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbl_confirmeSenha2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSenhaConf, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbl_email2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCargo))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbl_re)
                        .addGap(18, 18, 18)
                        .addComponent(txtRe, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbl_re)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nome1)
                    .addComponent(txtRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_email1)
                    .addComponent(lbl_email2)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_confirmeSenha2)
                        .addComponent(txtSenhaConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_senha2)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        setBounds(200, 135, 669, 419);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtSenhaConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaConfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaConfActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        //verifica se o campo senha e confirma senha são iguais
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        String senha = String.valueOf(txtSenha.getPassword());
        if (Arrays.equals(txtSenha.getPassword(), txtSenhaConf.getPassword()) && !senha.equals("")) {
            try {
                IDaoBase funcDao = new FuncionarioDAO();
                Funcionario func = new Funcionario();
                // verifica se o campo de texto RE estava vazio
                if (txtRe.getText().substring(0, 1).equals(" ")) {
                    JOptionPane.showMessageDialog(null, "Por Favor insira um RE");
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                } else {
                    func.setNome(txtNome.getText());
                    func.setLogin(txtLogin.getText());
                    func.setSenha(String.valueOf(txtSenha.getPassword()));
                    func.setCargo(txtCargo.getText());
                    func.setRe(Integer.parseInt(txtRe.getText()));
                    //verifica se alguma informação do objeto funcionario esta vazio
                    if (func.getLogin().equals("") || func.getCargo().equals("")) {
                        JOptionPane.showMessageDialog(null, "Por favor preencha o(s) campo(s) vazio(s)");
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    }else
                    {
                        // sava funcionario e exibe uma mensagem de cadastro com exito
                    funcDao.save(func);
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro ao confirmar senha!!");
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtRe.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtCargo.setText("");
        txtSenhaConf.setText("");
        txtNome.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_confirmeSenha2;
    private javax.swing.JLabel lbl_email1;
    private javax.swing.JLabel lbl_email2;
    private javax.swing.JLabel lbl_nome1;
    private javax.swing.JLabel lbl_re;
    private javax.swing.JLabel lbl_senha2;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRe;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaConf;
    // End of variables declaration//GEN-END:variables
}

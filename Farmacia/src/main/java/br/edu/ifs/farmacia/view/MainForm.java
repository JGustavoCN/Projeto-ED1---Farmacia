package br.edu.ifs.farmacia.view;

import br.edu.ifs.farmacia.controller.LoginController;
import br.edu.ifs.farmacia.controller.MainController;
import br.edu.ifs.farmacia.model.login.Usuario;
import java.awt.Color;

public class MainForm extends javax.swing.JFrame {

    private final Usuario usuario;

    public MainForm() {
        usuario = LoginController.getInstance().getUsuarioLogado();
        initComponents();
        getContentPane().setBackground(new Color(255, 255, 255));
        lbUser.setText(usuario.getUsername());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbUser.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(77, 77, 77));
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setText("User Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(518, 518, 518)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(543, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void start() {
        
         /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainForm loginForm = new MainForm();
            MainController.getInstance().setTelaAtual(loginForm);
            loginForm.setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbUser;
    // End of variables declaration//GEN-END:variables
}

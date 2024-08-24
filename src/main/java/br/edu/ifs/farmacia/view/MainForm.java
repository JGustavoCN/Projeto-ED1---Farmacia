package br.edu.ifs.farmacia.view;

import br.edu.ifs.farmacia.controller.MainController;
import br.edu.ifs.farmacia.view.component.PanelProdutos;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.UIManager;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

public class MainForm extends javax.swing.JFrame {

    //private final Usuario usuario;
    PanelProdutos panelProdutos;

    public MainForm() {
        //usuario = LoginController.getInstance().getUsuarioLogado();
        initComponents();
        init();
    }

    private void init() {
       
        GlassPanePopup.install(this);
        Notifications.getInstance().setJFrame(this);
        panelProdutos = new PanelProdutos();
        this.setLayout(new GridLayout());
        this.add(new PanelProdutos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1291, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void start() {
        FlatRobotoFont.install();
        
        //consertar o properties
        FlatLaf.registerCustomDefaultsSource("br.edu.ifs.farmacia.view.themes");
        
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainForm loginForm = new MainForm();
            MainController.getInstance().setTelaAtual(loginForm);
            loginForm.setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

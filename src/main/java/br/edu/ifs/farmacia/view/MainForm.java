package br.edu.ifs.farmacia.view;

import br.edu.ifs.farmacia.controller.MainController;
import br.edu.ifs.farmacia.view.component.PanelProdutos;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

public class MainForm extends javax.swing.JFrame {

    PanelProdutos panelProdutos;
    MainController mainController;

    public MainForm() {
        initComponents();
        init();
    }

    private static void modificarJFrame(JFrame frame) {

        GlassPanePopup.install(frame);
        Notifications.getInstance().setJFrame(frame);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Código a ser executado antes de fechar o programa
                int resposta = JOptionPane.showConfirmDialog(frame, "Você realmente deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    MainController.getInstance().salvarDados();
                    frame.dispose(); // Fecha o JFrame
                    //System.exit(0); // Remova esta linha para evitar o fechamento forçado
                }
            }
        });
    }

    private void init() {

        mainController = MainController.getInstance();
        panelProdutos = new PanelProdutos();
        this.setLayout(new GridLayout());
        this.add(panelProdutos);
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
            MainForm mainForm = new MainForm();

            modificarJFrame(mainForm);
            MainController.getInstance().setTelaAtual(mainForm);
            mainForm.setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

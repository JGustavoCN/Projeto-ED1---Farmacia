package br.edu.ifs.farmacia.view;

import br.edu.ifs.farmacia.controller.LoginController;
import br.edu.ifs.farmacia.controller.MainController;
import br.edu.ifs.farmacia.view.component.PanelCover;
import br.edu.ifs.farmacia.view.component.PanelLogin;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class LoginForm extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private PanelCover coverPanel;
    private PanelLogin loginPanel;
    private boolean isLogin = true;
    private final double addSize = 30;
    private final double coverPanelSize = 40;
    private final double loginPanelSize = 60;

    public LoginForm() {
        initComponents();
        init();
    }

    public PanelLogin getLoginPanel() {
        return loginPanel;
    }

    private void init() {
        
        bg.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
        layout = new MigLayout("fill, insets 0");
        coverPanel = new PanelCover();
        ActionListener eventLogin = (ActionEvent ae) -> login();
        loginPanel = new PanelLogin(eventLogin);
        
        TimingTarget target = getTimingTarget();
        Animator animator = getAnimator(target);
        bg.setLayout(layout);
        bg.add(coverPanel, "width " + coverPanelSize + "%, pos " + (isLogin ? "1al" : "0al") + " 0 n 100%");
        bg.add(loginPanel, "width " + loginPanelSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%"); //  1al as 100%
        loginPanel.trocarPanel(!isLogin);
        coverPanel.login(isLogin);
        coverPanel.addEvent((ActionEvent ae) -> {
            if (!animator.isRunning()) {
                animator.start();
            }
        });
    }
    
    
    public void login() {
        final String userName = loginPanel.getUserName();
        final String userPassword = loginPanel.getPassword();
        boolean resposta = LoginController.getInstance().logar(userName, userPassword);
        MainController.getInstance().logar(resposta);
    }
    
    private Animator getAnimator(TimingTarget timingTarget){
        Animator animator = new Animator(800, timingTarget);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation
        return animator;
    }
    
    private TimingTarget getTimingTarget(){
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverPanelSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        coverPanel.informacaoRight(fractionCover * 100);
                    } else {
                        coverPanel.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        coverPanel.informacaoLeft(fraction * 100);
                    } else {
                        coverPanel.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginPanel.trocarPanel(isLogin);
                }
                fractionCover = Double.parseDouble(df.format(fractionCover));
                fractionLogin = Double.parseDouble(df.format(fractionLogin));
                layout.setComponentConstraints(coverPanel, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginPanel, "width " + loginPanelSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        return target;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(933, 537));

        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatRobotoFont.install();
        // Caminho para o arquivo FlatLaf.properties
//        try {
//            File file = new File("src\\main\\resources\\themes\\FlatLaf.properties");
//
//            // Verifica se o arquivo existe
//            if (file.exists()) {
//
//                // Registra o local customizado para o FlatLaf
//                FlatLaf.registerCustomDefaultsSource(file);
//
//                // Inicia a aplicação ou outras operações
//                System.out.println("Tema customizado carregado: " + file);
//            } else {
//                System.err.println("O arquivo não foi encontrado: " + file.getAbsolutePath());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatIntelliJLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            LoginForm loginForm = new LoginForm();
            MainController.getInstance().setTelaAtual(loginForm);
            loginForm.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}

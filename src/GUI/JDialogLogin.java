package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class JDialogLogin extends JDialog {
    private JTextField textFieldLogin;
    private JPasswordField textFieldMotDePasse;
    private JPanel mainPanel;
    private JButton buttonOk;
    private JButton buttonAnnuler;

    private String login;
    private String motDePasse;
    private boolean ok;
    private Properties loginProperties;

    public JDialogLogin(JFrame parent, boolean modal, String titre) {
        super(parent, modal);
        setTitle(titre);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);

        ok = false;

        loginProperties = new Properties();

        try {
            //Chargement des données
            loginProperties.load(new FileInputStream("Login.properties"));
        } catch (FileNotFoundException ex) {

            loginProperties.setProperty("admin", "admin");

            try {
                loginProperties.store(new FileOutputStream("Login.properties"), "Table contenant les Login et Mot de Passe de tout les employes");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = textFieldLogin.getText();
                motDePasse = textFieldMotDePasse.getText();

                String tmpMotDePasse;

                if (!login.equals("") && !motDePasse.equals("")) {

                    tmpMotDePasse = loginProperties.getProperty(login, "KO");

                    // si on trouve le prenom d'employe et que le mdp est bon
                    if (tmpMotDePasse.equals(motDePasse)) {
                        ok = true;
                        setVisible(false);

                        JFrameAgenceBancaire frame = new JFrameAgenceBancaire();
                        frame.setVisible(true);

                    } else {
                        //Si on ne trouve pas le login
                        if (tmpMotDePasse.equals("KO")) {
                            JOptionPane.showMessageDialog(null, "Login Introuvable");
                        }
                        //Si Mdp Incorrecte
                        else {
                            JOptionPane.showMessageDialog(null, "Mdp Incorrecte");
                        }
                    }
                }

            }
        });

        buttonAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ok = false;
                setVisible(false);
            }
        });

    }

    public static void main(String[] args) {
        JDialogLogin dialogLogin = new JDialogLogin(null, true, "Entrée en session...");
        dialogLogin.setVisible(true);
        if (dialogLogin.isOk()) {
            System.out.println("Login = " + dialogLogin.getLogin());
            System.out.println("Mot de passe = " + dialogLogin.getMotDePasse());
        }
        dialogLogin.dispose();
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public boolean isOk() {
        return ok;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 4, new Insets(0, 0, 0, 0), -1, -1, false, true));
        mainPanel.setPreferredSize(new Dimension(320, 150));
        final JLabel label1 = new JLabel();
        label1.setText("Login :");
        mainPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(43, 30), null, 0, false));
        textFieldLogin = new JTextField();
        mainPanel.add(textFieldLogin, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Mot de passe :");
        mainPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(95, 30), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        mainPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(14, 175), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        mainPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(14, 175), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        mainPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonAnnuler = new JButton();
        buttonAnnuler.setPreferredSize(new Dimension(120, 30));
        buttonAnnuler.setText("Annuler");
        panel1.add(buttonAnnuler, BorderLayout.CENTER);
        buttonOk = new JButton();
        buttonOk.setPreferredSize(new Dimension(120, 30));
        buttonOk.setText("Ok");
        panel1.add(buttonOk, BorderLayout.WEST);
        textFieldMotDePasse = new JPasswordField();
        mainPanel.add(textFieldMotDePasse, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}

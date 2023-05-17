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

public class JDialogLogin extends JDialog
{
    private JTextField textFieldLogin;
    private JPasswordField textFieldMotDePasse;
    private JPanel mainPanel;
    private JButton buttonOk;
    private JButton buttonAnnuler;

    private String login;
    private String motDePasse;
    private boolean ok;
    private Properties loginProperties;

    public JDialogLogin(JFrame parent,boolean modal,String titre) {
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

                if(!login.equals("")  && !motDePasse.equals("")){

                    tmpMotDePasse = loginProperties.getProperty(login , "KO");

                    // si on trouve le prenom d'employe et que le mdp est bon
                    if(tmpMotDePasse.equals(motDePasse)){
                        ok = true;
                        setVisible(false);

                        JFrameAgenceBancaire frame = new JFrameAgenceBancaire();
                        frame.setVisible(true);

                    }
                    else{
                        //Si on ne trouve pas le login
                        if(tmpMotDePasse.equals("KO")){
                            /*ErrorMsg.setText("Login Introuvable");*/
                        }
                        //Si Mdp Incorrecte
                        else{
                            /*ErrorMsg.setText("Mdp Incorrecte");*/
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
        JDialogLogin dialogLogin = new JDialogLogin(null,true,"Entrée en session...");
        dialogLogin.setVisible(true);
        if (dialogLogin.isOk())
        {
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
}

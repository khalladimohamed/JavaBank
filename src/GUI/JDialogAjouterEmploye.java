package GUI;

import Agence.AgenceBancaire;
import Personne.Employe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

public class JDialogAjouterEmploye extends JDialog
{
    private JTextField textFieldNomEmploye;
    private JTextField textFieldPrenomEmploye;
    private JButton buttonAjouterEmploye;
    private JButton buttonAnnuler;
    private JPanel mainPanel;
    private JSpinner spinnerNaissanceJour;
    private JComboBox comboBoxNaissanceMois;
    private JSpinner spinnerNaissanceAnnee;
    private JSpinner spinnerEmboucheJour;
    private JComboBox comboBoxEmboucheMois;
    private JSpinner spinnerEmboucheAnnee;

    private String prenom;
    private String nom;
    private Calendar datenaiss;
    private Calendar dateEmbouche;
    private Properties loginProperties;

    public JDialogAjouterEmploye()
    {
        super();
        setContentPane(mainPanel);
        setTitle("Ajouter employe");
        pack();
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        buttonAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonAjouterEmploye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prenom = textFieldPrenomEmploye.getText();
                nom = textFieldNomEmploye.getText();
                int naissanceMonthIndex = comboBoxNaissanceMois.getSelectedIndex();
                int naissanceDay = (int) spinnerNaissanceJour.getValue();
                int naissanceYear = (int) spinnerNaissanceAnnee.getValue();
                datenaiss = Calendar.getInstance();
                datenaiss.set(Calendar.YEAR, naissanceYear);
                datenaiss.set(Calendar.MONTH, naissanceMonthIndex);
                datenaiss.set(Calendar.DAY_OF_MONTH, naissanceDay);
                int emboucheMonthIndex = comboBoxEmboucheMois.getSelectedIndex();
                int emboucheDay = (int) spinnerEmboucheJour.getValue();
                int emboucheYear = (int) spinnerEmboucheAnnee.getValue();
                dateEmbouche = Calendar.getInstance();
                dateEmbouche.set(Calendar.YEAR, emboucheYear);
                dateEmbouche.set(Calendar.MONTH, emboucheMonthIndex);
                dateEmbouche.set(Calendar.DAY_OF_MONTH, emboucheDay);

                // Accéder à l'instance unique de AgenceBancaire et ajouter l'employe
                AgenceBancaire agenceBancaire = AgenceBancaire.getInstance();
                Employe employe = new Employe(nom, prenom, datenaiss, agenceBancaire.genererIdEmploye(), dateEmbouche);
                agenceBancaire.getEmploye().add(employe);

                loginProperties = new Properties();
                try {
                    //Chargement des données
                    loginProperties.load(new FileInputStream("Login.properties"));
                    loginProperties.setProperty(prenom, nom);
                    loginProperties.store(new FileOutputStream("Login.properties"), "Table contenant les Login et Mot de Passe de tout les employes");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                JOptionPane.showMessageDialog(null, "L'employe a été ajouté");
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JDialogAjouterEmploye dialog = new JDialogAjouterEmploye();
        dialog.setVisible(true);
    }
}

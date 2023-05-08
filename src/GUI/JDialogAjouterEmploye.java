package GUI;

import Agence.AgenceBancaire;
import Personne.Client;
import Personne.Employe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

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

                setVisible(false);
            }
        });
    }


    public static void main(String[] args) {
        JDialogAjouterEmploye dialog = new JDialogAjouterEmploye();
        dialog.setVisible(true);
    }
}

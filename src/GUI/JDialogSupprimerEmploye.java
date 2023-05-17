package GUI;

import Agence.AgenceBancaire;
import Personne.Employe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JDialogSupprimerEmploye extends JDialog
{
    private JTextField textFieldIdEmploye;
    private JButton buttonSupprimerEmploye;
    private JButton buttonAnnuler;
    private JPanel mainPanel;

    private String idEmploye;


    public JDialogSupprimerEmploye()
    {
        super();
        setContentPane(mainPanel);
        setTitle("Supprimer employe");
        pack();
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Accéder à l'instance unique de AgenceBancaire
        AgenceBancaire agenceBancaire = AgenceBancaire.getInstance();

        buttonAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonSupprimerEmploye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idEmploye = textFieldIdEmploye.getText();
                // Récupération de la liste des employés
                ArrayList<Employe> employes = agenceBancaire.getEmploye();

                // Recherche de l'employé correspondant à l'ID saisi
                for (Employe employe : employes) {
                    if (employe.getIdEmploye().equals(idEmploye)) {
                        // Suppression de l'employé de la liste
                        employes.remove(employe);
                        break;
                    }
                }

                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JDialogSupprimerEmploye dialog = new JDialogSupprimerEmploye();
        dialog.setVisible(true);
    }
}

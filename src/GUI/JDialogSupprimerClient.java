package GUI;

import Agence.AgenceBancaire;
import Compte.CompteBancaire;
import Personne.Client;
import Service.Credit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogSupprimerClient extends JDialog
{
    private JTextField textFieldNomEmploye;
    private JTextField textFieldNumClient;
    private JButton buttonSupprimerClient;
    private JButton buttonAnnuler;
    private JPanel mainPanel;

    private int numClient;

    public JDialogSupprimerClient()
    {
        super();
        setContentPane(mainPanel);
        setTitle("Supprimer client");
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

        buttonSupprimerClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                numClient = Integer.parseInt(textFieldNumClient.getText());

                // Recherche du client correspondant à l'ID fourni
                Client clientASupprimer = null;
                for (Client c : agenceBancaire.getClient()) {
                    if (c.getNumClient() == numClient) {
                        clientASupprimer = c;
                        break;
                    }
                }

                // Verifier si le client est lier a un compte bancaire
                int clientLierCompte = 0;
                for (CompteBancaire cb : agenceBancaire.getCompteBancaire()) {
                    if (cb.getClient().equals(clientASupprimer)) {
                        clientLierCompte = 1;
                        break;
                    }
                }

                // Verifier si le client est lier a un credit
                int clientLierCredit = 0;
                for (Credit cr : agenceBancaire.getCredit()) {
                    if (cr.getClient().equals(clientASupprimer)) {
                        clientLierCredit = 1;
                        break;
                    }
                }

                // Suppression du client de la liste
                if (clientASupprimer != null && clientLierCompte == 0 && clientLierCredit == 0) {
                    agenceBancaire.getClient().remove(clientASupprimer);

                    JOptionPane.showMessageDialog(null, "Le client a été supprimé");
                } else {
                    if(clientLierCompte == 0 && clientLierCredit == 0)
                        JOptionPane.showMessageDialog(null, "Aucun client trouvé avec cette ID");
                    else
                        JOptionPane.showMessageDialog(null, "Ce client est lié a un compte bancaire ou un credit");
                }

                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JDialogSupprimerClient dialog = new JDialogSupprimerClient();
        dialog.setVisible(true);
    }
}

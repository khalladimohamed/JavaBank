package GUI;

import Agence.AgenceBancaire;
import Personne.Client;

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

                // Suppression du client de la liste
                if (clientASupprimer != null) {
                    agenceBancaire.getClient().remove(clientASupprimer);
                    System.out.println("Le client avec l'ID " + numClient + " a été supprimé.");
                } else {
                    System.out.println("Aucun client trouvé avec l'ID " + numClient + ".");
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

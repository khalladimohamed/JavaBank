package GUI;

import Agence.AgenceBancaire;
import Personne.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JDialogAfficherClient extends JDialog {
    private JTable tableClient;
    private JButton QuitterButton;
    private JPanel mainPanel;
    private JScrollPane scrollPaneClient;

    public JDialogAfficherClient() {
        super();
        setContentPane(mainPanel);
        setTitle("Afficher client");
        pack();
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(800, 600);

        String[] columnNames = {"Nom", "Prénom", "date de naissance", "numero du client", "Profession", "Salaire"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Récupérer l'instance unique de AgenceBancaire
        AgenceBancaire agence = AgenceBancaire.getInstance();
        ArrayList<Client> clients = agence.getClient();

        // Format de la date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Ajouter chaque client au modèle de la table
        for (Client client : clients) {
            Object[] rowData = {
                    client.getNom(),
                    client.getPrenom(),
                    dateFormat.format(client.getDateNaiss().getTime()),
                    client.getNumClient(),
                    client.getProfession(),
                    client.getSalaire()
            };
            model.addRow(rowData);
        }

        tableClient = new JTable(model);
        scrollPaneClient.setViewportView(tableClient);

        QuitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JDialogAfficherClient dialog = new JDialogAfficherClient();
        dialog.setVisible(true);
    }
}

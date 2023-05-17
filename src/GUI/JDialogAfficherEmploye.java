package GUI;

import Agence.AgenceBancaire;
import Personne.Employe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JDialogAfficherEmploye extends JDialog {
    private JTable tableEmploye;
    private JButton quitterButton;
    private JPanel mainPanel;
    private JScrollPane scrollPaneEmploye;

    public JDialogAfficherEmploye() {
        super();
        setContentPane(mainPanel);
        setTitle("Afficher employe");
        pack();
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(800, 600);

        String[] columnNames = {"Nom", "Prénom", "date de naissance", "ID employe", "date d'embouche"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Récupérer l'instance unique de AgenceBancaire
        AgenceBancaire agence = AgenceBancaire.getInstance();
        ArrayList<Employe> employes = agence.getEmploye();

        // Format de la date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Ajouter chaque client au modèle de la table
        for (Employe employe : employes) {
            Object[] rowData = {
                    employe.getNom(),
                    employe.getPrenom(),
                    dateFormat.format(employe.getDateNaiss().getTime()),
                    employe.getIdEmploye(),
                    dateFormat.format(employe.getDateEmbouche().getTime())
            };
            model.addRow(rowData);
        }

        tableEmploye = new JTable(model);
        scrollPaneEmploye.setViewportView(tableEmploye);

        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JDialogAfficherEmploye dialog = new JDialogAfficherEmploye();
        dialog.setVisible(true);

    }
}

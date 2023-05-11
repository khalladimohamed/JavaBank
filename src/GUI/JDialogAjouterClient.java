package GUI;

import Agence.AgenceBancaire;
import Personne.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


public class JDialogAjouterClient extends JDialog
{
    private JTextField textFieldNomClient;
    private JTextField textFieldPrenomClient;
    private JButton buttonAjouterClient;
    private JButton buttonAnnuler;
    private JPanel mainPanel;
    private JTextField textFieldProfession;
    private JTextField textFieldSalaire;
    private JSpinner spinnerJour;
    private JComboBox comboBoxMois;
    private JSpinner spinnerAnnee;

    private String prenom;
    private String nom;
    private Calendar datenaiss;
    private String profession;
    private Float salaire;


    public JDialogAjouterClient()
    {
        super();
        setContentPane(mainPanel);
        setTitle("Ajouter client");
        pack();
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


        buttonAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        buttonAjouterClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prenom = textFieldPrenomClient.getText();
                nom = textFieldNomClient.getText();
                int monthIndex = comboBoxMois.getSelectedIndex();
                int day = (int) spinnerJour.getValue();
                int year = (int) spinnerAnnee.getValue();
                datenaiss = Calendar.getInstance();
                datenaiss.set(Calendar.YEAR, year);
                datenaiss.set(Calendar.MONTH, monthIndex);
                datenaiss.set(Calendar.DAY_OF_MONTH, day);
                salaire = Float.parseFloat(textFieldSalaire.getText());
                profession = textFieldProfession.getText();

                // Accéder à l'instance unique de AgenceBancaire et ajouter le client
                AgenceBancaire agenceBancaire = AgenceBancaire.getInstance();
                Client client = new Client(nom, prenom, datenaiss, agenceBancaire.genererNumeroClient(), profession, salaire);
                agenceBancaire.getClient().add(client);


                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JDialogAjouterClient dialog = new JDialogAjouterClient();
        dialog.setVisible(true);

    }
}

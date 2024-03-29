package GUI;

import Agence.AgenceBancaire;
import Beans.AgeClientEvent;
import Beans.AgeClientListener;
import Personne.Client;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class JDialogAjouterClient extends JDialog implements AgeClientListener {
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


    public JDialogAjouterClient() {
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

                Client client = new Client();
                client.addAgeClientListener(JDialogAjouterClient.this);
                client.setNom(nom);
                client.setPrenom(prenom);
                client.setDateNaiss(datenaiss);
                client.setNumClient(agenceBancaire.genererNumeroClient());
                client.setProfession(profession);
                client.setSalaire(salaire);

                agenceBancaire.getClient().add(client);

                JOptionPane.showMessageDialog(null, "Le client a été ajouté");
                setVisible(false);
            }
        });
    }

    @Override
    public void ageClientAffiche(AgeClientEvent event) {
        // Réaction à l'événement d'affichage de l'âge
        int age = event.getAge();
        JOptionPane.showMessageDialog(null, "L'âge du client : " + age);
    }

    public static void main(String[] args) {
        JDialogAjouterClient dialog = new JDialogAjouterClient();
        dialog.setVisible(true);

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
        mainPanel.setLayout(new GridLayoutManager(8, 3, new Insets(10, 10, 10, 10), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Nom :");
        mainPanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldNomClient = new JTextField();
        mainPanel.add(textFieldNomClient, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Prenom :");
        mainPanel.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldPrenomClient = new JTextField();
        mainPanel.add(textFieldPrenomClient, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Date de naissance :");
        mainPanel.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel1, new GridConstraints(7, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonAjouterClient = new JButton();
        buttonAjouterClient.setText("Ajouter");
        panel1.add(buttonAjouterClient, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        buttonAnnuler = new JButton();
        buttonAnnuler.setText("Annuler");
        panel1.add(buttonAnnuler, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Profession :");
        mainPanel.add(label4, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldProfession = new JTextField();
        textFieldProfession.setText("");
        mainPanel.add(textFieldProfession, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Salaire :");
        mainPanel.add(label5, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldSalaire = new JTextField();
        mainPanel.add(textFieldSalaire, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        spinnerJour = new JSpinner();
        mainPanel.add(spinnerJour, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Jour :");
        mainPanel.add(label6, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxMois = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Janvier");
        defaultComboBoxModel1.addElement("Fevrier");
        defaultComboBoxModel1.addElement("Mars");
        defaultComboBoxModel1.addElement("Avril");
        defaultComboBoxModel1.addElement("Mai");
        defaultComboBoxModel1.addElement("Juin");
        defaultComboBoxModel1.addElement("Juillet");
        defaultComboBoxModel1.addElement("Aout");
        defaultComboBoxModel1.addElement("Septembre");
        defaultComboBoxModel1.addElement("Octobre");
        defaultComboBoxModel1.addElement("Novembre");
        defaultComboBoxModel1.addElement("Decembre");
        comboBoxMois.setModel(defaultComboBoxModel1);
        mainPanel.add(comboBoxMois, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        spinnerAnnee = new JSpinner();
        mainPanel.add(spinnerAnnee, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Mois :");
        mainPanel.add(label7, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Annee :");
        mainPanel.add(label8, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}

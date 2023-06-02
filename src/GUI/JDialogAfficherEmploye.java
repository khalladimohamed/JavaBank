package GUI;

import Agence.AgenceBancaire;
import Personne.Employe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        tableEmploye = new JTable();
        mainPanel.add(tableEmploye, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        quitterButton = new JButton();
        quitterButton.setText("Quitter");
        mainPanel.add(quitterButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scrollPaneEmploye = new JScrollPane();
        mainPanel.add(scrollPaneEmploye, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}

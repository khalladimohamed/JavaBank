package GUI;

import Agence.AgenceBancaire;
import Compte.CompteBancaire;
import Personne.Client;
import Service.CarteBancaire;
import Service.Credit;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class JFrameAgenceBancaire extends JFrame implements PropertyChangeListener {
    private JPanel mainPanel;
    private JTextField textFieldMontantCredit;
    private JTextField textFieldTauxInteret;
    private JButton buttonAttribuerCredit;
    private JTextField textFieldNumCompteBancaire;
    private JButton buttonSupprimerCompte;
    private JButton buttonCreerCompte;
    private JTextField textFieldSoldeCompte;
    private JTable tableInfoClient;
    private JScrollPane scrollPaneClient;
    private JTextField textFieldNumClientCompte;
    private JTextField textFieldNumClientCredit;

    private int numClientCompte;
    private float solde;
    private int numCompte;
    private int numClientCredit;
    private float montant;
    private float tauxInteret;


    public JFrameAgenceBancaire() {

        setSize(1400, 600);
        setTitle("Application JAVA Bank");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        JMenu menuConnexion = new JMenu("Connexion");
        menuBar.add(menuConnexion);
        JMenuItem menuItemLogin = new JMenuItem("Login");
        menuConnexion.add(menuItemLogin);
        JMenuItem menuItemLogout = new JMenuItem("Logout");
        menuConnexion.add(menuItemLogout);
        menuConnexion.addSeparator();
        JMenuItem menuItemQuitter = new JMenuItem("Quitter");
        menuConnexion.add(menuItemQuitter);


        JMenu menuEmployes = new JMenu("Employés");
        menuBar.add(menuEmployes);
        JMenuItem menuItemAjouterEmploye = new JMenuItem("Ajouter");
        menuEmployes.add(menuItemAjouterEmploye);
        JMenuItem menuItemSupprimerEmploye = new JMenuItem("Supprimer");
        menuEmployes.add(menuItemSupprimerEmploye);
        menuEmployes.addSeparator();
        JMenuItem menuItemAfficherEmploye = new JMenuItem("Afficher");
        menuEmployes.add(menuItemAfficherEmploye);


        JMenu menuClients = new JMenu("Clients");
        menuBar.add(menuClients);
        JMenuItem menuItemAjouterClient = new JMenuItem("Ajouter");
        menuClients.add(menuItemAjouterClient);
        JMenuItem menuItemSupprimerClient = new JMenuItem("Supprimer");
        menuClients.add(menuItemSupprimerClient);
        menuClients.addSeparator();
        JMenuItem menuItemAfficherClient = new JMenuItem("Afficher");
        menuClients.add(menuItemAfficherClient);


        JMenu menuComptes = new JMenu("Comptes bancaires");
        menuBar.add(menuComptes);
        JMenuItem menuItemAfficherComptes = new JMenuItem("Afficher");
        menuComptes.add(menuItemAfficherComptes);


        AgenceBancaire.getInstance().addPropertyChangeListener(this);


        // Désérialisation
        File file = new File("singleton.ser");

        if (file.length() != 0) {

            AgenceBancaire deserializedSingleton = null;

            try {
                FileInputStream fileIn = new FileInputStream("singleton.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                deserializedSingleton = (AgenceBancaire) in.readObject();
                in.close();
                fileIn.close();
                System.out.println("Le singleton a été désérialisé.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            AgenceBancaire.getInstance().setEmploye(deserializedSingleton.getEmploye());
            AgenceBancaire.getInstance().setClient(deserializedSingleton.getClient());
            AgenceBancaire.getInstance().setCompteBancaire(deserializedSingleton.getCompteBancaire());
            AgenceBancaire.getInstance().setCarteBacaire(deserializedSingleton.getCarteBacaire());
            AgenceBancaire.getInstance().setCredit(deserializedSingleton.getCredit());

        }

        AgenceBancaire agenceBancaire = AgenceBancaire.getInstance();

        menuItemLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogLogin dialog = new JDialogLogin(null, true, "Entrée en session...");
                dialog.setVisible(true);
            }
        });


        menuItemLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.getWindowAncestor(mainPanel);
                if (window != null) {
                    window.dispose();
                }

                JDialogLogin dialog = new JDialogLogin(null, true, "Entrée en session...");
                dialog.setVisible(true);
            }
        });


        menuItemQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Sérialisation
                AgenceBancaire singleton = AgenceBancaire.getInstance();

                FileOutputStream fileOut = null;
                ObjectOutputStream out = null;

                try {
                    fileOut = new FileOutputStream("singleton.ser");
                    out = new ObjectOutputStream(fileOut);
                    out.writeObject(singleton);
                    out.close();
                    fileOut.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println("Le singleton a été sérialisé.");

                System.exit(0);
            }
        });


        menuItemAjouterEmploye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogAjouterEmploye dialog = new JDialogAjouterEmploye();
                dialog.setVisible(true);
            }
        });


        menuItemSupprimerEmploye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogSupprimerEmploye dialog = new JDialogSupprimerEmploye();
                dialog.setVisible(true);
            }
        });


        menuItemAfficherEmploye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogAfficherEmploye dialog = new JDialogAfficherEmploye();
                dialog.setVisible(true);
            }
        });


        menuItemAjouterClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogAjouterClient dialog = new JDialogAjouterClient();
                dialog.setVisible(true);
            }
        });


        menuItemSupprimerClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogSupprimerClient dialog = new JDialogSupprimerClient();
                dialog.setVisible(true);
            }
        });


        menuItemAfficherClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogAfficherClient dialog = new JDialogAfficherClient();
                dialog.setVisible(true);
            }
        });

        menuItemAfficherComptes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogAfficherCompte dialog = new JDialogAfficherCompte();
                dialog.setVisible(true);
            }
        });


        buttonCreerCompte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numClientCompte = Integer.parseInt(textFieldNumClientCompte.getText());
                solde = Float.parseFloat(textFieldSoldeCompte.getText());

                // Recherche du client correspondant à l'ID fourni
                Client client = null;
                for (Client c : agenceBancaire.getClient()) {
                    if (c.getNumClient() == numClientCompte) {
                        client = c;
                        break;
                    }
                }

                if (client != null) {
                    int numPack = agenceBancaire.genererNumeroCompte();
                    CompteBancaire compteBancaire = new CompteBancaire(numPack, solde, client);
                    CarteBancaire carteBancaire = new CarteBancaire(numPack, client, compteBancaire, "Visa", 2000F, Calendar.getInstance());

                    agenceBancaire.getCompteBancaire().add(compteBancaire);
                    agenceBancaire.getCarteBacaire().add(carteBancaire);

                    JOptionPane.showMessageDialog(null, "Le compte bancaire est creé");
                } else {
                    JOptionPane.showMessageDialog(null, "Aucun client trouvé avec ce numero");
                }
            }
        });


        buttonSupprimerCompte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numCompte = Integer.parseInt(textFieldNumCompteBancaire.getText());

                // Recherche du compte bancaire correspondant à l'ID fourni
                CompteBancaire compteBancaireAsupprimer = null;
                CarteBancaire carteBancaireAsupprimer = null;

                for (CompteBancaire c : agenceBancaire.getCompteBancaire()) {
                    if (c.getNumCompte() == numCompte) {
                        compteBancaireAsupprimer = c;
                        break;
                    }
                }

                if (compteBancaireAsupprimer != null) {

                    for (CarteBancaire ca : agenceBancaire.getCarteBacaire()) {
                        if (ca.getNumService() == numCompte) {
                            carteBancaireAsupprimer = ca;
                            break;
                        }
                    }

                    // Verifier si le compte bancaire est lier a un credit
                    int compteLierCredit = 0;
                    for (Credit cr : agenceBancaire.getCredit()) {
                        if (cr.getClient().equals(compteBancaireAsupprimer.getClient())) {
                            compteLierCredit = 1;
                            break;
                        }
                    }

                    // Suppression du compte bancaire de la liste
                    if (compteBancaireAsupprimer != null && compteLierCredit == 0) {
                        agenceBancaire.getCompteBancaire().remove(compteBancaireAsupprimer);
                        agenceBancaire.getCarteBacaire().remove(carteBancaireAsupprimer);

                        JOptionPane.showMessageDialog(null, "Le compte bancaire a été supprimé");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ce compte bancaire est lié a un credit");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aucun compte bancaire trouvé avec cette ID");
                }
            }
        });


        buttonAttribuerCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                numClientCredit = Integer.parseInt(textFieldNumClientCredit.getText());
                montant = Float.parseFloat(textFieldMontantCredit.getText());
                tauxInteret = Float.parseFloat(textFieldTauxInteret.getText());

                // Recherche du client correspondant à l'ID fourni
                Client client = null;
                for (Client c : agenceBancaire.getClient()) {
                    if (c.getNumClient() == numClientCredit) {
                        client = c;
                        break;
                    }
                }

                if (client != null) {
                    Credit credit = new Credit(agenceBancaire.genererNumeroCredit(), client, montant, tauxInteret, Calendar.getInstance());
                    agenceBancaire.getCredit().add(credit);

                    //Pour envoyer le notify (beans)
                    agenceBancaire.setCredit(agenceBancaire.getCredit());

                    JOptionPane.showMessageDialog(null, "Le credit est attribué");
                } else {
                    JOptionPane.showMessageDialog(null, "Le client n'existe pas");
                }
            }
        });


        String[] columnNames = {"Nom", "Prénom", "Numéro de compte", "Solde", "Crédit"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Récupérer l'instance unique de AgenceBancaire
        AgenceBancaire agence = AgenceBancaire.getInstance();
        ArrayList<Credit> credits = agence.getCredit();
        ArrayList<CompteBancaire> compteBancaires = agence.getCompteBancaire();

        // Ajouter chaque credit au modèle de la table
        for (Credit credit : credits) {
            Object[] rowData = {
                    credit.getClient().getNom(),
                    credit.getClient().getPrenom(),
                    null,
                    null,
                    credit.getMontant()
            };

            //Ajouter les informations manqaunte sur le compte bancaire pour chaque credit
            for (CompteBancaire c : compteBancaires) {
                if (c.getClient().equals(credit.getClient())) {
                    rowData[2] = c.getNumCompte();
                    rowData[3] = c.getSolde();
                    break;
                }

            }

            model.addRow(rowData);
        }

        tableInfoClient = new JTable(model);
        scrollPaneClient.setViewportView(tableInfoClient);

    }

    public static void main(String[] args) {

        JFrameAgenceBancaire frame = new JFrameAgenceBancaire();
        frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        // Mettez à jour ma JTable ici en utilisant les nouvelles valeurs
        DefaultTableModel model = (DefaultTableModel) tableInfoClient.getModel();

        //vider la table pour la remplir apres
        model.setRowCount(0);

        // Récupérer l'instance unique de AgenceBancaire
        AgenceBancaire agence = AgenceBancaire.getInstance();
        ArrayList<Credit> credits = agence.getCredit();
        ArrayList<CompteBancaire> compteBancaires = agence.getCompteBancaire();

        // Ajouter chaque credit au modèle de la table
        for (Credit credit : credits) {
            Object[] rowData = {
                    credit.getClient().getNom(),
                    credit.getClient().getPrenom(),
                    null,
                    null,
                    credit.getMontant()
            };

            //Ajouter les informations manqaunte sur le compte bancaire pour chaque credit
            for (CompteBancaire c : compteBancaires) {
                if (c.getClient().equals(credit.getClient())) {
                    rowData[2] = c.getNumCompte();
                    rowData[3] = c.getSolde();
                    break;
                }
            }

            model.addRow(rowData);
        }
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
        mainPanel.setLayout(new GridLayoutManager(6, 9, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Numero de client :");
        mainPanel.add(label1, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(10, 10), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Numero du compte bancaire :");
        mainPanel.add(label2, new GridConstraints(2, 0, 2, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Numero de client :");
        mainPanel.add(label3, new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Montant :");
        mainPanel.add(label4, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Taux d'interet :");
        mainPanel.add(label5, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldMontantCredit = new JTextField();
        mainPanel.add(textFieldMontantCredit, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textFieldTauxInteret = new JTextField();
        mainPanel.add(textFieldTauxInteret, new GridConstraints(4, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        buttonAttribuerCredit = new JButton();
        buttonAttribuerCredit.setText("Attribuer un credit");
        mainPanel.add(buttonAttribuerCredit, new GridConstraints(4, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldNumCompteBancaire = new JTextField();
        mainPanel.add(textFieldNumCompteBancaire, new GridConstraints(2, 4, 2, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        buttonSupprimerCompte = new JButton();
        buttonSupprimerCompte.setText("Supprimer un compte bancaire");
        mainPanel.add(buttonSupprimerCompte, new GridConstraints(2, 7, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonCreerCompte = new JButton();
        buttonCreerCompte.setText("Creer un compte bancaire");
        mainPanel.add(buttonCreerCompte, new GridConstraints(1, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Solde :");
        mainPanel.add(label6, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldSoldeCompte = new JTextField();
        mainPanel.add(textFieldSoldeCompte, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        scrollPaneClient = new JScrollPane();
        mainPanel.add(scrollPaneClient, new GridConstraints(5, 0, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableInfoClient = new JTable();
        scrollPaneClient.setViewportView(tableInfoClient);
        textFieldNumClientCompte = new JTextField();
        mainPanel.add(textFieldNumClientCompte, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textFieldNumClientCredit = new JTextField();
        mainPanel.add(textFieldNumClientCredit, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setIcon(new ImageIcon(getClass().getResource("/GUI/logo.jpg")));
        label7.setText("");
        mainPanel.add(label7, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(29, 134), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}

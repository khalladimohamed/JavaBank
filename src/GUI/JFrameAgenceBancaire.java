package GUI;

import Agence.AgenceBancaire;
import Compte.CompteBancaire;
import Personne.Client;
import Service.CarteBancaire;
import Service.Credit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class JFrameAgenceBancaire extends JFrame {
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

        setSize(1400,600);
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


        // Accéder à l'instance unique de AgenceBancaire et ajouter le client
        AgenceBancaire agenceBancaire = AgenceBancaire.getInstance();


        menuItemLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogLogin dialog = new JDialogLogin(null,true,"Entrée en session...");
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

                JDialogLogin dialog = new JDialogLogin(null,true,"Entrée en session...");
                dialog.setVisible(true);
            }
        });


        menuItemQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                int numPack = agenceBancaire.genererNumeroCompte();
                CompteBancaire compteBancaire = new CompteBancaire(numPack, solde, client);
                CarteBancaire carteBancaire = new CarteBancaire(numPack, client, compteBancaire, "Visa", 2000F, Calendar.getInstance());

                agenceBancaire.getCompteBancaire().add(compteBancaire);
                agenceBancaire.getCarteBacaire().add(carteBancaire);
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
                    if (c.getNumCompte() == numClientCompte) {
                        compteBancaireAsupprimer = c;
                        break;
                    }
                }

                for (CarteBancaire ca : agenceBancaire.getCarteBacaire()) {
                    if (ca.getNumService() == numClientCompte) {
                        carteBancaireAsupprimer = ca;
                        break;
                    }
                }

                // Suppression du compte bancaire de la liste
                if (compteBancaireAsupprimer != null) {
                    agenceBancaire.getCompteBancaire().remove(compteBancaireAsupprimer);
                    agenceBancaire.getCarteBacaire().remove(carteBancaireAsupprimer);
                    System.out.println("Le compte bancaire avec l'ID " + numCompte + " a été supprimé.");
                } else {
                    System.out.println("Aucun compte bancaire trouvé avec l'ID " + numCompte + ".");
                }
            }
        });


        buttonAttribuerCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                numClientCredit = Integer.parseInt(textFieldNumClientCredit.getText());
                montant = Float.parseFloat(textFieldMontantCredit.getText());
                tauxInteret =  Float.parseFloat(textFieldTauxInteret.getText());

                // Recherche du client correspondant à l'ID fourni
                Client client = null;
                for (Client c : agenceBancaire.getClient()) {
                    if (c.getNumClient() == numClientCompte) {
                        client = c;
                        break;
                    }
                }

                Credit credit = new Credit(agenceBancaire.genererNumeroCredit(), client, montant, tauxInteret, Calendar.getInstance());
                agenceBancaire.getCredit().add(credit);
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
            for(CompteBancaire c : compteBancaires){
                if(c.getClient().equals(credit.getClient())){
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

}

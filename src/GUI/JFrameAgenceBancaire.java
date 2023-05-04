package GUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameAgenceBancaire extends JFrame {
    private JPanel mainPanel;
    private JComboBox comboBoxClientCredit;
    private JTextField textFieldMontantCredit;
    private JTextField textField3;
    private JButton buttonAttribuerCredit;
    private JComboBox comboBoxClientCompte;
    private JTextField textFieldNumCompteBancaire;
    private JButton buttonSupprimerCompte;
    private JButton buttonCreerCompte;
    private JTextField textFieldSoldeCompte;
    private JTable tableInfoClient;

    public JFrameAgenceBancaire() {

        setSize(800,600);
        setTitle("Application JAVA Bank");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();


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

        JMenu menuParametres = new JMenu("Paramètres");
        menuBar.add(menuParametres);


        buttonCreerCompte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        menuItemLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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





    }

    public static void main(String[] args) {

        JFrameAgenceBancaire frame = new JFrameAgenceBancaire();
        frame.setVisible(true);
    }

}

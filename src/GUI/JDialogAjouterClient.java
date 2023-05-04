package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class JDialogAjouterClient extends JDialog
{
    private JTextField textFieldNomClient;
    private JTextField textFieldPrenomClient;
    private JTextField textFieldDateNaissClient;
    private JButton buttonAjouterClient;
    private JButton buttonAnnuler;
    private JPanel mainPanel;
    private JTextField textFieldProfession;
    private JTextField textFieldSalaire;

    private String prenom;
    private String nom;
    private Date datenaiss;
    private Date dateEmbouche;
    private boolean ok;

    public JDialogAjouterClient()
    {
        super();
        setContentPane(mainPanel);
        setTitle("Ajouter client");
        pack();
        setModal(true);
        ok = false;
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
                ok = true;
                setVisible(false);
            }
        });
    }


    public boolean isOk() {
        return ok;
    }

    public static void main(String[] args) {
        JDialogAjouterClient dialog = new JDialogAjouterClient();
        dialog.setVisible(true);
        if (dialog.isOk())
        {

        }
        dialog.dispose();
    }
}

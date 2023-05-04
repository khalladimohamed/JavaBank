package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class JDialogSupprimerClient extends JDialog
{
    private JTextField textFieldNomEmploye;
    private JTextField textFieldNumClient;
    private JButton buttonSupprimerClient;
    private JButton buttonAnnuler;
    private JPanel mainPanel;

    private String prenom;
    private String nom;
    private Date datenaiss;
    private Date dateEmbouche;
    private boolean ok;

    public JDialogSupprimerClient()
    {
        super();
        setContentPane(mainPanel);
        setTitle("Supprimer client");
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
        buttonSupprimerClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prenom = textFieldNumClient.getText();
                nom = textFieldNomEmploye.getText();
                ok = true;
                setVisible(false);
            }
        });
    }


    public boolean isOk() {
        return ok;
    }

    public static void main(String[] args) {
        JDialogSupprimerClient dialog = new JDialogSupprimerClient();
        dialog.setVisible(true);
        if (dialog.isOk())
        {

        }
        dialog.dispose();
    }
}

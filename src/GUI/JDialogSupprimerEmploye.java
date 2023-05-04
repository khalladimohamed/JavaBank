package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class JDialogSupprimerEmploye extends JDialog
{
    private JTextField textFieldNomEmploye;
    private JTextField textFieldIdEmploye;
    private JButton buttonAjouterEmploye;
    private JButton buttonAnnuler;
    private JPanel mainPanel;

    private String prenom;
    private String nom;
    private Date datenaiss;
    private Date dateEmbouche;
    private boolean ok;

    public JDialogSupprimerEmploye()
    {
        super();
        setContentPane(mainPanel);
        setTitle("Supprimer employe");
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
        buttonAjouterEmploye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prenom = textFieldIdEmploye.getText();
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
        JDialogSupprimerEmploye dialog = new JDialogSupprimerEmploye();
        dialog.setVisible(true);
        if (dialog.isOk())
        {

        }
        dialog.dispose();
    }
}

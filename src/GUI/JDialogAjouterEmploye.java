package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class JDialogAjouterEmploye extends JDialog
{
    private JTextField textFieldNomEmploye;
    private JTextField textFieldPrenomEmploye;
    private JTextField textFieldDateNaissEmploye;
    private JButton buttonAjouterEmploye;
    private JButton buttonAnnuler;
    private JPanel mainPanel;
    private JTextField textFieldDateEmbouche;

    private String prenom;
    private String nom;
    private Date datenaiss;
    private Date dateEmbouche;
    private boolean ok;

    public JDialogAjouterEmploye()
    {
        super();
        setContentPane(mainPanel);
        setTitle("Ajouter employe");
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
                prenom = textFieldPrenomEmploye.getText();
                nom = textFieldNomEmploye.getText();
                //datenaiss = ;
                //dateEmbouche = ;
                ok = true;
                setVisible(false);
            }
        });
    }

    /*public String getCode() {
        return code;
    }

    public String getIntitule() {
        return intitule;
    }

    public float getPrix() {
        return prix;
    }*/

    public boolean isOk() {
        return ok;
    }

    public static void main(String[] args) {
        JDialogAjouterEmploye dialog = new JDialogAjouterEmploye();
        dialog.setVisible(true);
        if (dialog.isOk())
        {
            /*System.out.println("Code = " + dialog.getCode());
            System.out.println("Intitule = " + dialog.getIntitule());
            System.out.println("Prix = " + dialog.getPrix());*/
        }
        dialog.dispose();
    }
}

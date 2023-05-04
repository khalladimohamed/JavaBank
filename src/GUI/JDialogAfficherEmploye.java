package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAfficherEmploye extends JDialog {
    private JTable tableEmploye;
    private JButton quitterButton;
    private JPanel mainPanel;

    public JDialogAfficherEmploye() {
        super();
        setContentPane(mainPanel);
        setTitle("Afficher employe");
        pack();
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

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
}

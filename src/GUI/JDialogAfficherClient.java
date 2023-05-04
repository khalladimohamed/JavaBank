package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAfficherClient extends JDialog {
    private JTable tableClient;
    private JButton QuitterButton;
    private JPanel mainPanel;

    public JDialogAfficherClient() {
        super();
        setContentPane(mainPanel);
        setTitle("Afficher client");
        pack();
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        QuitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JDialogAfficherClient dialog = new JDialogAfficherClient();
        dialog.setVisible(true);

    }
}



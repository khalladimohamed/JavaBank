import GUI.JDialogLogin;


public class Main {
    public static void main(String[] args) {
        com.formdev.flatlaf.FlatDarculaLaf.setup();
        JDialogLogin dialogLogin = new JDialogLogin(null,true,"Entrée en session...");
        dialogLogin.setVisible(true);
    }
}

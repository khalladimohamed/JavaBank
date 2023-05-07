package Personne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Employe extends Personne{
    private String idEmploye;
    private Date dateEmbouche;

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Date getDateEmbouche() {
        return dateEmbouche;
    }

    public void setDateEmbouche(Date dateEmbouche) {
        this.dateEmbouche = dateEmbouche;
    }

    public Employe() {
        super();
        this.idEmploye = "";
        this.dateEmbouche = new Date();
    }

    public Employe(String idEmploye, Date dateEmbouche) {
        this.idEmploye = idEmploye;
        this.dateEmbouche = dateEmbouche;
    }

    public Employe(String nom, String prenom, Calendar dateNaiss, String idEmploye, Date dateEmbouche) {
        super(nom, prenom, dateNaiss);
        this.idEmploye = idEmploye;
        this.dateEmbouche = dateEmbouche;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "idEmploye='" + idEmploye + '\'' +
                ", dateEmbouche=" + dateEmbouche +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaiss=" + dateNaiss +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employe employe = (Employe) o;
        return Objects.equals(idEmploye, employe.idEmploye) && Objects.equals(dateEmbouche, employe.dateEmbouche);
    }

    public static void main(String[] args) {
        // Création d'un objet Employe
        Employe employe = new Employe();
        employe.setNom("Doe");
        employe.setPrenom("John");
        employe.setDateNaiss(Calendar.getInstance());

        employe.setIdEmploye("001");
        Date dateEmbouche = new Date();
        employe.setDateEmbouche(dateEmbouche);

        // Affichage de l'employé
        System.out.println(employe);

        // Comparaison de deux employés
        Employe employe2 = new Employe();
        employe2.setNom("Doe");
        employe2.setPrenom("John");
        employe2.setDateNaiss(Calendar.getInstance());
        employe2.setIdEmploye("001");
        employe2.setDateEmbouche(dateEmbouche);

        System.out.println(employe.equals(employe2)); //true
    }


}

package Personne;

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

    public Employe(String nom, String prenom, Date dateNaiss, String idEmploye, Date dateEmbouche) {
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

}

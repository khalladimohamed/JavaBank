package Personne;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public abstract class Personne implements Serializable {
    protected String nom;
    protected String prenom;
    protected Calendar dateNaiss;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Calendar getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Calendar dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Personne() {
        this.nom = "";
        this.prenom = "";
        this.dateNaiss = Calendar.getInstance();
    }

    public Personne(String nom, String prenom, Calendar dateNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaiss=" + dateNaiss +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(dateNaiss, personne.dateNaiss);
    }


}



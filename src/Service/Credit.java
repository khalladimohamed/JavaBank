package Service;

import Personne.Client;
import Personne.Employe;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Credit extends ServiceBancaire {
    private Float montant;
    private Float tauxInteret;
    private Employe employe;
    private Date dateSignature;

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    @Override
    public Date getDateInstauration() {
        return getDateSignature();
    }

    @Override
    public void setDateInstauration(Date dateInstauration) {
        setDateSignature(dateInstauration);
    }

    public Credit() {
        super();
        this.montant = Float.valueOf(0);
        this.tauxInteret = Float.valueOf(0);
        this.employe = null;
        this.dateSignature = new Date();
    }

    public Credit(Float montant, Float tauxInteret, Employe employe, Date dateSignature) {
        this.montant = montant;
        this.tauxInteret = tauxInteret;
        this.employe = employe;
        this.dateSignature = dateSignature;
    }

    public Credit(int numService, Client client, Float montant, Float tauxInteret, Employe employe, Date dateSignature) {
        super(numService, client);
        this.montant = montant;
        this.tauxInteret = tauxInteret;
        this.employe = employe;
        this.dateSignature = dateSignature;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "montant=" + montant +
                ", tauxInteret=" + tauxInteret +
                ", employe=" + employe +
                ", dateSignature=" + dateSignature +
                ", numService=" + numService +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Credit credit = (Credit) o;
        return Objects.equals(montant, credit.montant) && Objects.equals(tauxInteret, credit.tauxInteret) && Objects.equals(employe, credit.employe) && Objects.equals(dateSignature, credit.dateSignature);
    }

    public static void main(String[] args) {
        // Création d'un employé
        Employe employe = new Employe("John", "Doe", Calendar.getInstance(), "01", Calendar.getInstance());

        // Création d'un client
        Client client = new Client("Boo", "Mark", Calendar.getInstance(), 12345, "Ingénieur", 5000f);

        // Création d'un crédit
        Credit credit = new Credit(1, client, 10000f, 0.05f, employe, new Date());

        // Affichage des informations sur le crédit
        System.out.println(credit);

        // Modification du montant du crédit
        credit.setMontant(15000f);

        // Affichage des informations sur le crédit modifié
        System.out.println(credit);
    }

}

package Service;

import Personne.Client;

import java.util.Calendar;
import java.util.Objects;

public class Credit extends ServiceBancaire {
    private Float montant;
    private Float tauxInteret;
    private Calendar dateSignature;

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

    public Calendar getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Calendar dateSignature) {
        this.dateSignature = dateSignature;
    }

    @Override
    public Calendar getDateInstauration() {
        return getDateSignature();
    }

    @Override
    public void setDateInstauration(Calendar dateInstauration) {
        setDateSignature(dateInstauration);
    }

    public Credit() {
        super();
        this.montant = Float.valueOf(0);
        this.tauxInteret = Float.valueOf(0);
        this.dateSignature = Calendar.getInstance();
    }

    public Credit(Float montant, Float tauxInteret, Calendar dateSignature) {
        this.montant = montant;
        this.tauxInteret = tauxInteret;
        this.dateSignature = dateSignature;
    }

    public Credit(int numService, Client client, Float montant, Float tauxInteret, Calendar dateSignature) {
        super(numService, client);
        this.montant = montant;
        this.tauxInteret = tauxInteret;
        this.dateSignature = dateSignature;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "montant=" + montant +
                ", tauxInteret=" + tauxInteret +
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
        return Objects.equals(montant, credit.montant) && Objects.equals(tauxInteret, credit.tauxInteret) && Objects.equals(dateSignature, credit.dateSignature);
    }

    public static void main(String[] args) {

        // Création d'un client
        Client client = new Client("Boo", "Mark", Calendar.getInstance(), 12345, "Ingénieur", 5000f);

        // Création d'un crédit
        Credit credit = new Credit(1, client, 10000f, 0.05f, Calendar.getInstance());

        // Affichage des informations sur le crédit
        System.out.println(credit);

        // Modification du montant du crédit
        credit.setMontant(15000f);

        // Affichage des informations sur le crédit modifié
        System.out.println(credit);
    }

}

package Service;

import Compte.CompteBancaire;
import Personne.Client;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CarteBancaire extends ServiceBancaire {
    private CompteBancaire Compte;
    private String type;
    private Float plafond;
    private Date dateRemise;

    public CompteBancaire getCompte() {
        return Compte;
    }

    public void setCompte(CompteBancaire compte) {
        Compte = compte;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPlafond() {
        return plafond;
    }

    public void setPlafond(Float plafond) {
        this.plafond = plafond;
    }

    public Date getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(Date dateRemise) {
        this.dateRemise = dateRemise;
    }

    @Override
    public Date getDateInstauration() {
        return getDateRemise();
    }

    @Override
    public void setDateInstauration(Date dateInstauration) {
        setDateRemise(dateInstauration);
    }

    public CarteBancaire() {
        super();
        Compte = null;
        this.type = "";
        this.plafond = Float.valueOf(0);
        this.dateRemise = new Date();
    }

    public CarteBancaire(int numService, Client client, CompteBancaire compte, String type, Float plafond, Date dateRemise) {
        super(numService, client);
        Compte = compte;
        this.type = type;
        this.plafond = plafond;
        this.dateRemise = dateRemise;
    }

    @Override
    public String toString() {
        return "CarteBancaire{" +
                "Compte=" + Compte +
                ", type='" + type + '\'' +
                ", plafond=" + plafond +
                ", dateRemise=" + dateRemise +
                ", numService=" + numService +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarteBancaire that = (CarteBancaire) o;
        return Objects.equals(Compte, that.Compte) && Objects.equals(type, that.type) && Objects.equals(plafond, that.plafond) && Objects.equals(dateRemise, that.dateRemise);
    }

    public static void main(String[] args) {
        // Création d'un client
        Client client = new Client("Boo", "Mark", Calendar.getInstance(), 12345, "Ingénieur", 5000f);

        // Création d'un compte bancaire
        CompteBancaire compte = new CompteBancaire(12, 500F, client);

        // Création d'une carte bancaire
        CarteBancaire carte = new CarteBancaire(2, client, compte, "Visa", 1000.0f, new Date());

        // Affichage des informations de la carte bancaire
        System.out.println(carte);
    }

}

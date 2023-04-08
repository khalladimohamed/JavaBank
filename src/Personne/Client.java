package Personne;

import java.util.Date;
import java.util.Objects;

public class Client extends Personne{
    private int numClient;
    private String profession;
    private Float salaire;

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Float getSalaire() {
        return salaire;
    }

    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }

    public Client() {
        super();
        this.numClient = 0;
        this.profession = "";
        this.salaire = Float.valueOf(0);
    }

    public Client(int numClient, String profession, Float salaire) {
        this.numClient = numClient;
        this.profession = profession;
        this.salaire = salaire;
    }

    public Client(String nom, String prenom, Date dateNaiss, int numClient, String profession, Float salaire) {
        super(nom, prenom, dateNaiss);
        this.numClient = numClient;
        this.profession = profession;
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Client{" +
                "numClient=" + numClient +
                ", profession='" + profession + '\'' +
                ", salaire=" + salaire +
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
        Client client = (Client) o;
        return numClient == client.numClient && Objects.equals(profession, client.profession) && Objects.equals(salaire, client.salaire);
    }

}

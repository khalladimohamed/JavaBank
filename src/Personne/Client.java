package Personne;

import java.util.Calendar;
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

    public Client(String nom, String prenom, Calendar dateNaiss, int numClient, String profession, Float salaire) {
        super(nom, prenom, dateNaiss);
        this.numClient = numClient;
        this.profession = profession;
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return String.valueOf(numClient);
                /*"Client{" +
                "numClient=" + numClient +
                ", nom='" + nom + '\'' +
                '}';*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return numClient == client.numClient && Objects.equals(profession, client.profession) && Objects.equals(salaire, client.salaire);
    }


    public static void main(String[] args) {

        // création d'un client avec les informations fournies
        Client client1 = new Client("Doe", "John", Calendar.getInstance(), 12345, "Ingénieur", 5000f);

        // affichage du client créé
        System.out.println(client1);

        // création d'un autre client avec des informations différentes
        Date autreDateNaissance = new Date(); // utilisation de la date courante
        Client client2 = new Client("Doe", "Jane", Calendar.getInstance(), 67890, "Professeur", 4000f);

        // affichage du deuxième client créé
        System.out.println(client2);

        // test d'égalité entre les deux clients
        System.out.println("Les clients sont égaux : " + client1.equals(client2));
    }

}

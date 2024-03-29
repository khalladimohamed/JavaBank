package Personne;

import Beans.AgeClientListener;
import Beans.AgeClientEvent;
import java.util.*;

public class Client extends Personne
{
    private int numClient;
    private String profession;
    private Float salaire;
    protected transient List<AgeClientListener> ageClientListeners;

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

    public void setDateNaiss(Calendar dateNaiss) {
        super.setDateNaiss(dateNaiss);
        int age = calculerAge(dateNaiss);
        fireAgeClientAffiche(age);
    }

    public Client() {
        super();
        this.numClient = 0;
        this.profession = "";
        this.salaire = Float.valueOf(0);
        ageClientListeners = new ArrayList<>();
    }

    public Client(int numClient, String profession, Float salaire) {
        this.numClient = numClient;
        this.profession = profession;
        this.salaire = salaire;
        ageClientListeners = new ArrayList<>();
    }

    public Client(String nom, String prenom, Calendar dateNaiss, int numClient, String profession, Float salaire) {
        super(nom, prenom, dateNaiss);
        this.numClient = numClient;
        this.profession = profession;
        this.salaire = salaire;
        ageClientListeners = new ArrayList<>();
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

    private int calculerAge(Calendar dateNaissance) {
        Calendar currentDate = Calendar.getInstance();
        int age = currentDate.get(Calendar.YEAR) - dateNaissance.get(Calendar.YEAR);

        return age;
    }

    public void addAgeClientListener(AgeClientListener listener) {
        ageClientListeners.add(listener);
    }

    public void removeAgeClientListener(AgeClientListener listener) {
        ageClientListeners.remove(listener);
    }

    // Lorsque on calcule l'âge, on appele cette méthode pour informer les écouteurs
    private void fireAgeClientAffiche(int age) {
        AgeClientEvent event = new AgeClientEvent(this, age);
        for (AgeClientListener listener : ageClientListeners) {
            listener.ageClientAffiche(event);
        }
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
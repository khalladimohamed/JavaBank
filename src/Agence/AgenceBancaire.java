package Agence;


import Compte.CompteBancaire;
import Personne.Client;
import Personne.Employe;
import Service.CarteBancaire;
import Service.Credit;

import java.io.Serializable;
import java.util.ArrayList;


public class AgenceBancaire implements Serializable {

    //ArrayListe<Employe>() pour la securite (ne pas mettre n'imopte quoi dans la liste)
    private ArrayList<Employe> employe;
    private ArrayList<Client> client;
    private ArrayList<CompteBancaire> compteBancaire;
    private ArrayList<CarteBancaire> carteBacaire;
    private ArrayList<Credit> credit;
    private static AgenceBancaire instance;

    public ArrayList<Employe> getEmploye() {
        return employe;
    }

    public void setEmploye(ArrayList<Employe> employe) {
        this.employe = employe;
    }

    public ArrayList<Client> getClient() {
        return client;
    }

    public void setClient(ArrayList<Client> client) {
        this.client = client;
    }

    public ArrayList<CompteBancaire> getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(ArrayList<CompteBancaire> compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public ArrayList<CarteBancaire> getCarteBacaire() {
        return carteBacaire;
    }

    public void setCarteBacaire(ArrayList<CarteBancaire> carteBacaire) {
        this.carteBacaire = carteBacaire;
    }

    public ArrayList<Credit> getCredit() {
        return credit;
    }

    public void setCredit(ArrayList<Credit> credit) {
        this.credit = credit;
    }


    private AgenceBancaire() {
        employe = new ArrayList<Employe>();
        client = new ArrayList<Client>();
        compteBancaire = new ArrayList<CompteBancaire>();
        carteBacaire = new ArrayList<CarteBancaire>();
        credit = new ArrayList<Credit>();
    }

    // Méthode statique pour obtenir l'instance unique de la classe
    public static AgenceBancaire getInstance() {
        if (instance == null) {
            // Création de l'instance uniquement lors du premier appel
            instance = new AgenceBancaire();
        }
        return instance;
    }

    public int genererNumeroClient() {
        if (client.isEmpty()) {
            // Si la liste des clients est vide, on commence par 1
            return 1;
        } else {
            // Recherche du dernier numéro de client
            int dernierNumero = 0;
            for (Client c : client) {
                if (c.getNumClient() > dernierNumero) {
                    dernierNumero = c.getNumClient();
                }
            }
            // Incrémentation du dernier numéro et retour du nouveau numéro de client
            return dernierNumero + 1;
        }
    }
}

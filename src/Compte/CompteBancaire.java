package Compte;

import Personne.Client;

import java.util.Objects;

public class CompteBancaire {
    int numCompte;
    Float solde;
    Client client;

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CompteBancaire() {
        this.numCompte = 0;
        this.solde = Float.valueOf(0);
        this.client = null;
    }

    public CompteBancaire(int numCompte, Float solde, Client client) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.client = client;
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "numCompte=" + numCompte +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompteBancaire that = (CompteBancaire) o;
        return numCompte == that.numCompte && Objects.equals(solde, that.solde) && Objects.equals(client, that.client);
    }

}

package Service;

import Personne.Client;
import java.util.Date;
import java.util.Objects;

public abstract class ServiceBancaire implements DateInstauration {
    int numService;
    Date dateCreation;
    Client client;

    public int getNumService() {
        return numService;
    }

    public void setNumService(int numService) {
        this.numService = numService;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ServiceBancaire() {
        this.numService = 0;
        this.dateCreation = new Date();
        this.client = null;
    }

    public ServiceBancaire(int numService, Date dateCreation, Client client) {
        this.numService = numService;
        this.dateCreation = dateCreation;
        this.client = client;
    }

    @Override
    public String toString() {
        return "ServiceBancaire{" +
                "numService=" + numService +
                ", dateCreation=" + dateCreation +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceBancaire that = (ServiceBancaire) o;
        return numService == that.numService && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(client, that.client);
    }

}

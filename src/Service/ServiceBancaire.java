package Service;

import Personne.Client;

import java.io.Serializable;
import java.util.Objects;

public abstract class ServiceBancaire implements DateInstauration, Serializable {
    protected int numService;
    protected Client client;

    public int getNumService() {
        return numService;
    }

    public void setNumService(int numService) {
        this.numService = numService;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ServiceBancaire() {
        this.numService = 0;
        this.client = null;
    }

    public ServiceBancaire(int numService, Client client) {
        this.numService = numService;
        this.client = client;
    }

    @Override
    public String toString() {
        return "ServiceBancaire{" +
                "numService=" + numService +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceBancaire that = (ServiceBancaire) o;
        return numService == that.numService && Objects.equals(client, that.client);
    }

}

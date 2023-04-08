package Service;

import Personne.Client;

import java.util.Date;
import java.util.Objects;

public class CarteBancaire extends ServiceBancaire {
    private String type;
    private Float plafond;
    private Date dateRemise;

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
        this.type = "";
        this.plafond = Float.valueOf(0);
        this.dateRemise = new Date();
    }

    public CarteBancaire(int numService, Client client, String type, Float plafond, Date dateRemise) {
        super(numService, client);
        this.type = type;
        this.plafond = plafond;
        this.dateRemise = dateRemise;
    }

    @Override
    public String toString() {
        return "CarteBancaire{" +
                "type='" + type + '\'' +
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
        return Objects.equals(type, that.type) && Objects.equals(plafond, that.plafond) && Objects.equals(dateRemise, that.dateRemise);
    }

}

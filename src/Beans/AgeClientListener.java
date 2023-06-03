package Beans;

import java.util.EventListener;

public interface AgeClientListener extends EventListener {
    void ageClientAffiche(AgeClientEvent event);
}

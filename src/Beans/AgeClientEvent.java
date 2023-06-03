package Beans;

import java.util.EventObject;

public class AgeClientEvent extends EventObject {
    private int age;

    public AgeClientEvent(Object source, int age) {
        super(source);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

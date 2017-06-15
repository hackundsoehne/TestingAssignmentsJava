package de.hackundsoehne.bootcamp.tooling.template.testing.database;

/**
 */
public class Customer {
    private final String name;
    private final String telephoneNumber;

    public Customer(String name, String telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
}

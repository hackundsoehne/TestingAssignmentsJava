package de.hackundsoehne.bootcamp.tooling.template.testing.database;

/**
 */
public class Sale {
    private final int customer;
    private final int volume;

    public Sale(int customer, int volume) {
        this.customer = customer;
        this.volume = volume;
    }

    public int getCustomer() {
        return customer;
    }

    public int getVolume() {
        return volume;
    }
}

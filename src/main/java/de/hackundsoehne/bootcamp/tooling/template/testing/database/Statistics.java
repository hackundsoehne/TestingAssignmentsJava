package de.hackundsoehne.bootcamp.tooling.template.testing.database;
import java.util.*;
import java.util.stream.Collectors;

/**
 */
public class Statistics {
    private final DatabaseQueries db;

    public Statistics(DatabaseQueries db) {
        this.db = db;
    }

    /**
     * calculates the average Sale per customer
     * @return a map with the customer-id as a key and the volume averaged as value
     */
    public Map<Integer, Double> getAverageSalePerCustomer() {
        return db.getSales().stream()
                .collect(Collectors.groupingBy(Sale::getCustomer, Collectors.averagingInt(Sale::getVolume)));

    }

    /**
     * calculates the minimum Sale per customer
     * @return see getAverageSalePerCustomer
     */
    public Map<Integer, Integer> getMinimumSalePerCustomer() {
        return db.getSales().stream()
                .collect(Collectors.groupingBy(Sale::getCustomer,
                        Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Sale::getVolume)),
                                opt -> opt.get().getVolume())));

    }

    /**
     * returns the customer with the highest volume
     */
    public Customer getBestCustomer() {
        Integer bestCustomer = db.getSales().stream()
                .collect(Collectors.groupingBy(Sale::getCustomer, Collectors.summarizingInt(Sale::getVolume)))
                .entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue().getSum()))
                //i know it's bad, but simpler example
                .get()
                .getKey();

        return db.getCustomer(bestCustomer);
    }

    /**
     * returns the average sale per customer
     */
    public Map<Customer, Double> getAverageSaleWithCustomer() {
        return db.getSales().stream()
                .collect(
                        Collectors.groupingBy(customer -> db.getCustomer(customer.getCustomer())
                        , Collectors.averagingInt(Sale::getVolume))
                );
    }
}

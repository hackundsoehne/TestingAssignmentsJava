package de.hackundsoehne.bootcamp.tooling.template.testing;

/**
 */
public class Person {
    //for example: 1995
    private final int birthDate;

    public Person(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge(int currentYear) {
        if (currentYear < 0 || birthDate > currentYear) {
            throw new IllegalArgumentException("travelling through time is not supported");
        }
        return currentYear - birthDate;
    }

    public boolean canDrinkBeer(int currentYear) {
        int age = getAge(currentYear);
        return age >= 16;
    }

    public boolean canVote(int currentYear) {
        int age = getAge(currentYear);
        return age >= 18;
    }
}

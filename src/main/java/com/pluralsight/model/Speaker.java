package com.pluralsight.model;

public class Speaker {

    private final double seed;
    private String firstName;
    private String lastName;

    public Speaker(String firstName, String lastName, double seed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.seed = seed;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSeed() {
        return seed;
    }
}

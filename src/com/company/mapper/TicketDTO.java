package com.company.mapper;

import java.util.Arrays;

public class TicketDTO {

    private String firstName;
    private String lastName;
    private int perPlace;
    private String flightFrom;
    private String flightTo;
    private String[] transplantations;

    public int getPersonPlace() {
        return perPlace;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personPlace='" + perPlace + '\'' +
                ", flightFrom='" + flightFrom + '\'' +
                ", transplantations=" + Arrays.toString(transplantations) +
                ", flightTo='" + flightTo + '\'' +
                '}';
    }

    public void setPersonPlace(int perPlace) {
        this.perPlace = perPlace;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public String[] getTransplantations() {
        return transplantations;
    }

    public void setTransplantations(String[] transplantations) {
        this.transplantations = transplantations;
    }
}

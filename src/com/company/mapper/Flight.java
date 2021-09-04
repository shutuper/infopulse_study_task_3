package com.company.mapper;

public class Flight {

    private Person passenger;
    @MinVal(min = 14)
    private int place;
    private String from;
    @Transplantation(transplantations = {"Madrid", "Rome"})
    private String to;
    private int kilometers;

    public Person getPerson() {
        return passenger;
    }

    public String getPersonFirstName() {
        return passenger.getFirstName();
    }

    public String getPersonLastName() {
        return passenger.getLastName();
    }

    public void setPerson(Person person) {
        this.passenger = person;
    }

    public int getPersonPlace() {
        return place;
    }

    public Flight(Person passenger, int place, String from, String to, int kilometers) {
        this.passenger = passenger;
        this.place = place;
        this.from = from;
        this.to = to;
        this.kilometers = kilometers;
    }

    public void setPersonPlace(int personPlace) {
        this.place = personPlace;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
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
    }
}

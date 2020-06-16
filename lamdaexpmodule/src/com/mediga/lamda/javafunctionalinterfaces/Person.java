package com.mediga.lamda.javafunctionalinterfaces;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static com.mediga.lamda.javafunctionalinterfaces.Gender.FEMALE;
import static com.mediga.lamda.javafunctionalinterfaces.Gender.MALE;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Gender gender;
    private double income;

    public Person(int id, String firstName, Gender gender, LocalDate dob, double income) {
        this.id = id;
        this.firstName = firstName;
        this.dob = dob;
        this.gender = gender;
        this.income = income;
    }

    public Person(String firstName, String lastName, LocalDate dob, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public boolean isMale() {
        return this.gender == MALE;
    }

    public boolean isFemale() {
        return this.gender == FEMALE;
    }

    @Override
    public String toString() {
        String str = String.format("(%s, %s, %s, %s, %.2f)", id, firstName, gender, dob, income);
        return str;
    }

    // A convenience method
    public static List<Person> getPersons() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("John", "Jacobs", LocalDate.of(1975, 1, 20), MALE));
        list.add(new Person("Wally", "Inman", LocalDate.of(1965, 9, 12), MALE));
        list.add(new Person("Donna", "Jacobs", LocalDate.of(1970, 9, 12), FEMALE));
        return list;
    }

    public static List<Person> persons() {
        Person ken = new Person(1, "Ken", Gender.MALE, LocalDate.of(1970, Month.MAY, 4), 6000.0);
        Person jeff = new Person(2, "Jeff", Gender.MALE, LocalDate.of(1970, Month.JULY, 15), 7100.0);
        Person donna = new Person(3, "Donna", Gender.FEMALE, LocalDate.of(1962, Month.JULY, 29), 8700.0);
        Person chris = new Person(4, "Chris", Gender.MALE, LocalDate.of(1993, Month.DECEMBER, 16), 1800.0);
        Person laynie = new Person(5, "Laynie", Gender.FEMALE, LocalDate.of(2012, Month.DECEMBER, 13), 0.0);
        Person lee = new Person(6, "Li", Gender.MALE, LocalDate.of(2001, Month.MAY, 9), 2400.0);
        // Create a list of persons
        List<Person> persons = List.of(ken, jeff, donna, chris, laynie, lee);
        return persons;
    }
}

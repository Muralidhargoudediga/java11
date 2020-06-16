package com.mediga.streams;

import com.mediga.lamda.javafunctionalinterfaces.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

//Partitioning collects data into two groups: for one group a condition is true; for the other, the same condition is false
public class PartitionByTest {
    public static void main(String[] args) {
        Map<Boolean, List<Person>> partitioningByMaleGender = Person.persons()
                .stream()
                .collect(partitioningBy(Person::isMale));

        System.out.println(partitioningByMaleGender);

        Map<Boolean, String> partitioningByMaleGenderNames = Person.persons()
                .stream()
                .collect(partitioningBy(Person::isMale, mapping(Person::getFirstName, joining(", "))));

        System.out.println(partitioningByMaleGenderNames);
    }
}

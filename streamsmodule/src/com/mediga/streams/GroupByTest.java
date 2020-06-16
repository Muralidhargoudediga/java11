package com.mediga.streams;

import com.mediga.lamda.javafunctionalinterfaces.Gender;
import com.mediga.lamda.javafunctionalinterfaces.Person;

import java.time.Month;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class GroupByTest {
    public static void main(String[] args) {
        Map<Gender, List<Person>> personsByGender = Person.persons()
                .stream()
                .collect(groupingBy(Person::getGender));

        System.out.println(personsByGender);

        Map<Gender, Long> countByGender = Person.persons()
                .stream()
                .collect(groupingBy(Person::getGender, Collectors.counting()));

        System.out.println(countByGender);

        Map<Gender, List<String>> namesByGender = Person.persons()
                .stream()
                .collect(groupingBy(Person::getGender, mapping(Person::getFirstName, Collectors.toList())));

        System.out.println(namesByGender);

        Map<Gender, Map<Month, List<String>>> namesByGenderandDobMonth = Person.persons()
                .stream()
                .collect(groupingBy(Person::getGender, groupingBy(p -> p.getDob().getMonth(), mapping(Person::getFirstName, toList()))));

        System.out.println(namesByGenderandDobMonth);

        Map<Gender, DoubleSummaryStatistics> incomeStatsByGender = Person.persons()
                .stream()
                .collect(groupingBy(Person::getGender, summarizingDouble(Person::getIncome)));

        System.out.println(incomeStatsByGender);
    }
}

package com.mediga.streams;

import com.mediga.lamda.javafunctionalinterfaces.Gender;
import com.mediga.lamda.javafunctionalinterfaces.Person;

import java.time.Month;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.Map.entry;
import static java.util.stream.Collectors.*;

/*
This is the type of collector that collects the data and lets you modify the result before and after collecting the data.
 You can adapt the result of the collector to a different type; you can filter the elements after they are grouped but before they are collected;
 you map elements as they are grouped, but before they are collected
*/
public class AdaptingCollectorResultsTest {
    public static void main(String[] args) {
        //The collectingAndThen() method lets you modify the results of a collector after the collector has collected all elements.
        // Its first argument is a collector that collects the data. The second argument is a finisher that is a function
        List<String> names = Person.persons()
                .stream()
                .map(Person::getFirstName)
                .collect(collectingAndThen(toList(), list -> Collections.unmodifiableList(list)));
        System.out.println(names);

        //Suppose you want to print a calendar that contains the names of people by the month of their dates of birth.
        //If no birthday is there in month print 'None' for that month

        Map<Month, String> dobCalendar = Person.persons()
                .stream()
                .collect(collectingAndThen(groupingBy(p -> p.getDob().getMonth(), mapping(Person::getFirstName, joining(", "))), result -> {
                    for(Month month : Month.values()) {
                        result.putIfAbsent(month, "None");
                    }

                    return Collections.unmodifiableMap(new TreeMap<>(result));
                }));

        System.out.println(dobCalendar);

        Map<Gender, List<Person>> makingOver8000 = Person.persons()
                .stream()
                .collect(groupingBy(Person::getGender, filtering(p -> p.getIncome() > 8000, toList())));

        System.out.println(makingOver8000);

        /*summarize the table's data by grouping people by their gender and the list of unique languages spoken by people of each gender type.
                                            Name    Gender  Language
                                            ----   -------  --------
                                            Ken     Male    English, French
                                            Jeff    Male    Spanish, Wu
                                            Donna   Female  English, French
                                            Chris   Male    Wu, Lao
                                            Laynie  Female  English, German
                                            Li      Male    English

         */

        List<Entry<String, Set<String>>> list = List.of(entry("Male", Set.of("English", "French")),
                                                        entry("Male", Set.of("Spanish", "Wu")),
                                                        entry("Male", Set.of("Wu", "Lao")),
                                                        entry("Male", Set.of("English")),
                                                        entry("Female", Set.of("English", "French")),
                                                        entry("Female", Set.of("English", "German")));

        Map<String, Set<String>> languagesByGender = list.stream()
                .collect(groupingBy(Entry::getKey, flatMapping(e -> e.getValue().stream(), toSet())));

        System.out.println(languagesByGender);
    }
}

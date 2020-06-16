package com.mediga.streams;

import com.mediga.lamda.javafunctionalinterfaces.Gender;
import com.mediga.lamda.javafunctionalinterfaces.Person;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsToMap {
    public static void main(String[] args) {
        Map<Integer, String> idToNameMap = Person.persons()
                                                    .stream()
                                                    .collect(Collectors.toMap(Person::getId, Person::getFirstName));
        System.out.println(idToNameMap);

        /*
                Throws IllegalStateException because of duplicate keys
                Map<Gender, String> genderToNamesMap = Person.persons()
                                                            .stream()
                                                            .collect(Collectors.toMap(Person::getGender, Person::getFirstName));
        */

        //Use mergeFunction argument of toMap() when duplicate keys are there
        Map<Gender, String> genderToNamesMap = Person.persons()
                .stream()
                .collect(Collectors.toMap(Person::getGender, Person::getFirstName, (oldValue, newValue) -> String.join(", ", oldValue, newValue)));

        System.out.println(genderToNamesMap);

        Map<Gender, Long> countByGender = Person.persons()
                .stream()
                .collect(Collectors.toMap(Person::getGender, p->1L, (oldValue, newValue) -> oldValue+1));

        System.out.println(countByGender);

        Map<Gender, Person> highestEarnerByGender = Person.persons()
                .stream()
                .collect(Collectors.toMap(Person::getGender, Function.identity(), (oldPerson, newPerson) -> oldPerson.getIncome() < newPerson.getIncome() ? newPerson : oldPerson));

        System.out.println(highestEarnerByGender);

    }
}

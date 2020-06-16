package com.mediga.streams;

import com.mediga.lamda.javafunctionalinterfaces.Person;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class SummaryStatistics {
    public static void main(String[] args) {
        //You can use Summary Statistics Without Streams
        DoubleSummaryStatistics summaryStatistics = new DoubleSummaryStatistics();
        summaryStatistics.accept(100);
        summaryStatistics.accept(500);
        summaryStatistics.accept(400);

        System.out.printf("count=%d, sum=%.2f, min=%.2f, max=%.2f, average=%.2f%n", summaryStatistics.getCount(), summaryStatistics.getSum(),
                summaryStatistics.getMin(), summaryStatistics.getMax(), summaryStatistics.getAverage());

        //With Streams
        DoubleSummaryStatistics incomeStats = Person.persons()
                                                    .stream()
                                                    .map(Person::getIncome)
                                                    .collect(DoubleSummaryStatistics::new,
                                                            DoubleSummaryStatistics::accept,
                                                            DoubleSummaryStatistics::combine);
        System.out.println(incomeStats);

        incomeStats = Person.persons()
                .stream()
                .collect(Collectors.summarizingDouble(Person::getIncome));

        System.out.println(incomeStats);
    }
}

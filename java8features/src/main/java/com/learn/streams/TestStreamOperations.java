package com.learn.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestStreamOperations {

    public static void main(String[] args) {
       var total = Arrays.stream(DataRepo.nums)
                .filter(num -> num % 3 == 0)
                .sum();

        System.out.println(total);

        IntSummaryStatistics statistics = Arrays.stream(DataRepo.nums)
                .summaryStatistics();

        System.out.println(statistics);
        System.out.println(statistics.getSum());
        System.out.println("+++++++++++++++++++++++++++++++");

        Predicate<String> lengthGreaterThanFour = state -> state.length() >= 4;
        DataRepo.states.stream()  //"Karnataka", "Delhi","Goa", "Goa","UttarPradesh", "Tamilnadu"
                .filter(lengthGreaterThanFour)
                .filter(state -> state.contains("na"))
                .sorted(Comparator.reverseOrder())
                .map(state -> state.substring(0,3).toUpperCase().concat(state.substring(3)) )
                .forEach(System.out::println);

        String statesCollected = DataRepo.states.stream()
                .collect(Collectors.joining(";", "{", "}"));
        System.out.println(statesCollected);

        System.out.println("+++++++++++++++++++++++++++++++");



        Set<String> electronicsProductNames = DataRepo.products.stream()
                .filter(prod -> prod.getCategory().equalsIgnoreCase("electronics"))
                .map(Product::getName)
                .collect(Collectors.toSet());
        System.out.println(electronicsProductNames);
        System.out.println("+++++++++++++++++++++++++++++++");
        LinkedList<Product> electronicsProducts = DataRepo.products.stream()
                .filter(prod -> prod.getCategory().equalsIgnoreCase("electronics"))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(electronicsProducts);
        System.out.println("+++++++++++++++++++++++++++++++");

        IntSummaryStatistics collect = DataRepo.products.stream()
                .map(Product::getPrice)
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(collect);


    }
}

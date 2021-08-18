package com.learn.collectors;

import com.learn.streams.DataRepo;
import com.learn.streams.Product;

import java.util.*;
import java.util.stream.Collectors;

public class TestCollectors {

    public static void main(String[] args) {

        Map<String, String> stateCodes = DataRepo.states.stream()
                .collect(Collectors.toMap(
                        state -> state,
                        state -> state.toUpperCase().substring(0, 3),
                        (oldVal, newVal) -> newVal,
                        TreeMap::new
                ));

        System.out.println(stateCodes);


        String category = "clothingxyz";
        //find the product with the highest price for the given catg

        Optional<Product> collect = DataRepo.products.stream()
                .filter(prod -> prod.getCategory().equals(category))
                .collect(Collectors.maxBy(Comparator.comparing(Product::getPrice)));


        collect.ifPresentOrElse(System.out::println,
                                () ->  System.out.println("Not Found")
            );


        //grouping
        Map<String, List<Product>> categoryProducts = DataRepo.products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println(categoryProducts);


        // get a map of catg and list of product names
        Map<String, List<String>> catgProdNameList = DataRepo.products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.mapping(prod -> prod.getName(), Collectors.toCollection(LinkedList::new))));

        System.out.println(catgProdNameList);

        Map<String, String> catgProdNames = DataRepo.products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.mapping(prod -> prod.getName(),
                                Collectors.joining(",", "{","}"))
                ));
        System.out.println(catgProdNames);

        Map<String, DoubleSummaryStatistics> catgSummary = DataRepo.products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.summarizingDouble(Product::getPrice)));
        System.out.println(catgSummary);
    }
}

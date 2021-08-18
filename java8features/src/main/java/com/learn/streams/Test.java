package com.learn.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Product> collect = DataRepo.products.stream()
                .sorted(Comparator.comparing(Product::getSupplier, Comparator.comparing(Supplier::getSupplierName).reversed())
                        .thenComparing(Product::getCategory)).collect(Collectors.toList());

        System.out.println(collect);

        Map<String, Integer> prices = Map.of("mobile", 10000, "toy", 500);

        prices.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + entry.getValue());
                });

        //prices.values().stream()
        //prices.keySet().stream()


    }
}

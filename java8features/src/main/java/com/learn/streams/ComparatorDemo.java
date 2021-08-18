package com.learn.streams;

import java.util.Comparator;

public class ComparatorDemo {

    public static void main(String[] args) {

        DataRepo.states.sort(Comparator.comparing(String::length).reversed());
        System.out.println(DataRepo.states);

        DataRepo.products.sort(Comparator
                    .comparing(Product::getCategory)
                    .thenComparing(Product::getPrice, Comparator.reverseOrder()));

        System.out.println(DataRepo.products);


    }
}

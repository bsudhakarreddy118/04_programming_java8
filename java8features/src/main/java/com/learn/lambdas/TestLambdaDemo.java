package com.learn.lambdas;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestLambdaDemo {

    public static void main(String[] args) {

        List<String> products = new ArrayList<>(List.of("Mobile", "Computer", "Jeans", "Tshirt", "Mouse"));
        List<String> mProducts = new ArrayList<>();

        Consumer<String> addToList = prod -> {
            if (prod.startsWith("M")) {
                mProducts.add(prod);
            }
        };
        products.forEach(addToList);
        System.out.println(mProducts);

        mProducts.forEach(pr -> System.out.println(pr));


//        Collections.sort(products, );
        Comparator<String> descProducts = (prod1, prod2) ->
            prod1.length() > prod2.length() ? 1 : prod1.length() < prod2.length() ? -1 : 0;

        products.sort(descProducts);


        products.sort((prod1, prod2)-> prod2.compareTo(prod1));
        Predicate<String> productOf5Chars = prod -> prod.length() == 5;
        System.out.println(productOf5Chars.test("hello"));

        products.removeIf(productOf5Chars);
        System.out.println(products);

        Map<String, Integer> scores = Map.of("dhoni", 50, "virat", 75);

        scores.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });


    }
}

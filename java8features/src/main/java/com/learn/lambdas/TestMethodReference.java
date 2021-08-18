package com.learn.lambdas;

import java.util.ArrayList;
import java.util.List;

public class TestMethodReference {

    public static void main(String[] args) {
        int test = 0;
        List<String> products = new ArrayList<>(List.of("Mobile", "Computer", "Jeans", "Tshirt", "Mouse"));

        products.forEach(System.out::println); //products.forEach(prod -> System.out.println(prod))
        System.out.println("*******length sort");
        products.sort(TestMethodReference::compareByLength);
        products.forEach(System.out::println);
        System.out.println("*******Descending");
        TestMethodReference mref = new TestMethodReference();
        products.sort(mref::reverseOrder);
    }

    public static int compareByLength(String prod1, String prod2){
        return prod1.length() > prod2.length() ? 1 : prod1.length() < prod2.length() ? -1 : 0;
    }

    public int reverseOrder(String prod1, String prod2){
        return prod2.compareTo(prod1);
    }



}

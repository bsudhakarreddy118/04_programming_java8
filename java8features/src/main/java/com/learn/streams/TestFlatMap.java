package com.learn.streams;

import java.util.Arrays;
import java.util.List;

public class TestFlatMap {

    public static void main(String[] args) {

        List<Integer[]> numberSets = List.of(
                new Integer[]{1,2,3},
                new Integer[]{4,5,6});

        numberSets.stream()
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
    }

}

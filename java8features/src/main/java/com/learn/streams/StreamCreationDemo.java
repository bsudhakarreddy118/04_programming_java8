package com.learn.streams;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationDemo {

    public static void main(String[] args) {
        Stream<String> statesStream = DataRepo.states.stream();
        System.out.println(statesStream.count());
       // statesStream.count();

        System.out.println(Arrays.stream(DataRepo.nums).max());

        Stream<String> fruits = Stream.of("apple", "mango");

        Stream.iterate(10, num -> num + 2)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("===========================");

        IntStream.rangeClosed(10, 30).forEach(System.out::println);
        System.out.println("===========================");

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        Stream.generate(() -> Math.ceil(Math.random() * 1000)).limit(5).forEach(System.out::println);
    }
}

package com.learn.collectors;

import com.learn.streams.DataRepo;
import com.learn.streams.Product;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Map<String, Integer> collect = DataRepo.products.stream().collect(Collectors.groupingBy(
                product -> product.getSupplier().getSupplierName(),
                Collectors.mapping(Product::getPrice,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.naturalOrder()), Optional::get))


        ));

    }
}

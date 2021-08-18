package com.learn.streams;

import javax.xml.crypto.Data;
import java.util.Comparator;
import java.util.Optional;

public class TestStreamOperations2 {

    public static void main(String[] args) {

        Optional<Product> optionalProduct = DataRepo.products.stream()
                .filter(prod -> prod.getProdCode() == 1042)
                .findFirst();

//        optionalProduct.ifPresent(System.out::println);

/*        if(optionalProduct.isPresent()){
            Product p = optionalProduct.get();
        }*/

        Product product = optionalProduct.orElseThrow(RuntimeException::new);
        System.out.println(product);

        Optional<Product> empty = Optional.empty();
//        Optional<Product> optProduct =  Optional.of(product);
        Optional<Product> optProduct =  Optional.ofNullable(product);

        boolean found = DataRepo.products.parallelStream()
                .anyMatch(prod -> prod.getProdCode() == 104);



    }
}

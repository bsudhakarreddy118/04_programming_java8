package com.learn.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class TestNIO2 {

    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("src", "main", "resources", "test.txt");

        System.out.println(filePath.toAbsolutePath());

        System.out.println(Files.exists(filePath));

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        List<String> allLines = Files.readAllLines(filePath);

    }
}

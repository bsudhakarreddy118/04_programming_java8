package com.learn.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoordinatesDemo {

    public static void main(String[] args) {

        //Read the file and return the List of Coordinates
        Path filePath = Paths.get("src", "main", "resources", "folder1", "coordinates.txt");
        Optional<List<Coordinate>> coordinatesList = getCoordinatesList(filePath);

        coordinatesList.ifPresent(System.out::println);

        if(coordinatesList.isPresent()){
            List<Coordinate> coordinates = coordinatesList.get();
            coordinates.forEach(System.out::println);
        }

    }


    public static Optional<List<Coordinate>> getCoordinatesList(Path filePath){
        Optional<List<Coordinate>> coordinatesList = Optional.empty();

        try(Stream<String> lines = Files.newBufferedReader(filePath).lines()){
            List<Coordinate> collect = lines
                    .map(CoordinatesDemo::getCoordinate)
                    .collect(Collectors.toList());

            coordinatesList = Optional.of(collect);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return coordinatesList;
    }

    public static Coordinate getCoordinate(String str){
        String[] coordinates = str.split(",");
        return new Coordinate(coordinates[0], coordinates[1]);
    }
}

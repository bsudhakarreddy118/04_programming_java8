package com.learn.nio2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class TestFiles {

    public static void main(String[] args) throws IOException {
        Path folderPath = Paths.get("src", "main", "resources");

        //List all the files in a given directory
        Stream<Path> pathStream = Files.list(folderPath);
        pathStream.forEach(TestFiles::printPathDetails);
        System.out.println("====================");

        //Walk a path and process all files/folders
        Stream<Path> pathStream2 = Files.walk(folderPath);
        pathStream2.forEach(TestFiles::printPathDetails);



        Path path2 = folderPath.resolve("test2.txt");
        System.out.println(path2);

        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path2, StandardOpenOption.CREATE)){
            bufferedWriter.write("testing");
            bufferedWriter.flush();
        }
    }

    public static void printPathDetails(Path path){
        System.out.println(Files.isDirectory(path));
        System.out.println(path.getFileName());
    }

}

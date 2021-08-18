package com.learn.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestPathSearch {

    public static void main(String[] args) {

        Path srcFolder = Paths.get("src");
        Path absolutePath = srcFolder.toAbsolutePath();
        System.out.println(absolutePath.getParent());
        System.out.println(absolutePath.getNameCount());

        System.out.println(Files.isRegularFile(srcFolder));
        System.out.println(Files.isDirectory(srcFolder));
        System.out.println(Files.exists(srcFolder));

        // list, walk

        try(Stream<Path> files = Files.walk(srcFolder)){

            files
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(TestPathSearch::printPathDetails);

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static void printPathDetails(Path path){
        if(Files.isDirectory(path)){
            System.out.println(">>> " + path.getFileName());
        }else{
            System.out.println("-------- " + path.getFileName());
        }




    }
}

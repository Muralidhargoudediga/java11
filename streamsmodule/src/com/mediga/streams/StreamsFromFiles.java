package com.mediga.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamsFromFiles {
    public static void main(String[] args) {
        readFileContents("luci1.txt");
        listFileTree();
    }

    public static void readFileContents(String filePath) {
        Path path = Paths.get(filePath);
        if(!Files.exists(path)) {
            System.out.println("The file " + path.toAbsolutePath() + " does not exists");
        }

        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listFileTree(){
        Path path = Paths.get("");
        System.out.printf("%nThe file tree for %s%n", path.toAbsolutePath());

        try(Stream<Path> paths = Files.walk(path)) {
            paths.filter(p -> !p.startsWith(Paths.get(".git"))).forEach(System.out::println)
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.myproject.euler.exercises.exercise42;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TriangleValues {
    private Map<Integer, Double> values = new ConcurrentHashMap<>();

    public void calculateTriangleValues() {
        Path path = Paths.get("src/main/resources/p042_words.txt");
        try {
            long count = Files.readAllLines(path).parallelStream()
                    .map(line -> line.split(","))
                    .flatMap(Arrays::stream)
                    .parallel()
                    .filter(w -> isTriangle(w))
                    .count();
            System.out.println("Nr of triangle words = " + count);
        } catch (IOException ex) {
            ex.printStackTrace();//handle exception here
        }
    }

    public int calculateValue(String word) {
        word = word.replace("\"", "");
        int value = 0;
        for (int i = 0; i < word.length(); i++) {
            value += word.charAt(i) - 'A' + 1;
        }
        return value;
    }

    public boolean isTriangle(String word) {
        int value = calculateValue(word);
        int i = 1;
        double triangle = 0;
        while (triangle < value) {
            triangle = i * (i + 1) * 1 / 2;
            if (triangle == value) {
                System.out.println(word);
                return true;
            }
            i++;
        }
        return false;
    }
}

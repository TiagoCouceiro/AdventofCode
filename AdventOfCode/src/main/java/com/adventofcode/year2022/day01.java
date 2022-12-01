package com.adventofcode.year2022;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class day01 {

    static public List<Integer> parseCalories(InputStream in) throws IOException {
        String content = new String(in.readAllBytes(), StandardCharsets.UTF_8);

        return Arrays.stream(content.split("\n\n"))
                .map(line -> Arrays.stream(line.split("\n"))
                        .map(Integer::parseInt)
                        .reduce(0, Integer::sum))
                .sorted(Collections.reverseOrder())
                .toList();
    }

    static public Integer part01(InputStream in) throws IOException {
        return parseCalories(in).get(0);
    }

    static public Integer part02(InputStream in) throws IOException {
        return parseCalories(in)
                .stream()
                .limit(3)
                .reduce(0,Integer::sum);
    }
}
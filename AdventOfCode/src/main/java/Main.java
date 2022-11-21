package main.java;

import main.java.com.adventofcode.year2021.Day3;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Day3 day3 = new Day3(new FileInputStream("day3input.txt"));
        day3.run2();
    }
}
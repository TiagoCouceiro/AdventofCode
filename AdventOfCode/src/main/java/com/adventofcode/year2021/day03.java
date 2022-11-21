package com.adventofcode.y2021;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class day03 {
    static public List<int[]> ParseDigits(InputStream in) {
        return new BufferedReader(new InputStreamReader(in))
                .lines()
                .map(line -> line.chars()
                        .map(ch -> ch - '0')
                        .toArray())
                .toList();
    }

    static public int part01(InputStream in) {
        List<int[]> diagnostic = ParseDigits(in);

        int bits = diagnostic.get(0).length;
        int majority = diagnostic.size() / 2;
        int[] bitCount = new int[bits];

        for (int[] line : diagnostic) {
            for (int i = 0; i < line.length; i++) {
                if (line[i] == 1) {
                    bitCount[i] += 1;
                }
            }
        }

        int gamma = 0;
        for (int i : bitCount) {
            gamma <<= 1; // swift left as we go
            gamma |= i > majority ? 1 : 0; // set the bit
        }

        // (1 << bits) - 1 turn on all bits in a set of size
        // ^ bitwise xor
        int epsilon = ((1 << bits) -1 ) ^ gamma;

        return gamma * epsilon;
    }

    public int part02() {
        return 0;
    }
}

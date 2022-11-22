package com.adventofcode.y2021;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;

public class day03 {
    static public List<int[]> ParseDigits(InputStream in) {
        return new BufferedReader(new InputStreamReader(in))
                .lines()
                .map(line -> line.chars()
                        .map(ch -> ch - '0')
                        .toArray())
                .toList();
    }

    static public int[] onesFrequency(List<int[]> diagnostic) {
        int bits = diagnostic.get(0).length;
        int[] bitCount = new int[bits];

        for (int[] line : diagnostic) {
            for (int i = 0; i < line.length; i++) {
                if (line[i] == 1) {
                    bitCount[i] += 1;
                }
            }
        }

        return bitCount;
    }
    static public int part01(InputStream in) {
        List<int[]> diagnostic = ParseDigits(in);

        int majority = diagnostic.size() / 2;
        int bitWidth = diagnostic.get(0).length;
        int[] freq = onesFrequency(diagnostic);

        int gamma = 0;
        for (int i : freq) {
            gamma <<= 1; // swift left as we go
            gamma |= i > majority ? 1 : 0; // set the bit
        }

        // (1 << bits) - 1 turn on all bits in a set of size
        // ^ bitwise xor
        int epsilon = ((1 << bitWidth) -1 ) ^ gamma;

        return gamma * epsilon;
    }

    public static int mostCommon(List<int[]> diagnostic, BiPredicate<Integer, Integer> predicate) {
        int bitWidth = diagnostic.get(0).length;

        for (int i = 0; i < bitWidth; i++) {
            final int index = i;
            int[] onesFreq = onesFrequency(diagnostic);
            int max = diagnostic.size();
            int zeroFreq  = max - onesFreq[i];
            int toRemove = onesFreq[i] >= zeroFreq ? 0 : 1;

            diagnostic = diagnostic.stream().filter(a -> predicate.test(a[index], toRemove)).toList();

            if (diagnostic.size() == 1) break;
        }

        // convert for example [ 0, 1, 0, 1, 0 ] to 10
        return Arrays.stream(diagnostic.get(0)).reduce(0, (acc, el) -> (acc << 1) + el);
    }

    public static int part02(InputStream in) {
        List<int[]> diagnostic = ParseDigits(in);

        int oxygen = mostCommon(diagnostic, (most, digit) -> !Objects.equals(most, digit));
        int co2 = mostCommon(diagnostic, Objects::equals);

        return oxygen * co2;
    }
}

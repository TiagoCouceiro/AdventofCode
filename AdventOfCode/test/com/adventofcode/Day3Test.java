package com.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void run2() {
        ArrayList array = new ArrayList(Arrays.asList(1,2,3));
        ArrayList array2 = new ArrayList(Arrays.asList(1,2,3,4));
        assertEquals(array,array2);
    }
}
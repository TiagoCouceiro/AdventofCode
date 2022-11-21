package main.java.com.adventofcode.year2021;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

    /**
     * PART 2
     */
    InputStream file;

    Scanner sc;


    public Day3(InputStream file) {
        this.file = file;
    }

    public void run2() {

        ArrayList<String> list = new ArrayList<>();

        sc = new Scanner(file);

        String line = "";
        String oxygenBit = "";
        String co2Bit = "";

        int counter1;
        int counter0;

        int decimalOxygen = 0;
        int decimalCo2 = 0;


        while (sc.hasNext()) {

            line = sc.nextLine();
            list.add(line);

        }

        for(int i = 0; i < line.length(); i++) {

            counter1 = 0;
            counter0 = 0;


            for(int j = 0; j < list.size(); j++) {

                if(list.get(j).charAt(i) == '1') {

                    counter1++;

                } else {

                    counter0++;

                }
            }

            if(counter1 >= counter0) {

                oxygenBit += '1';

            } else if(counter0 > counter1) {

                oxygenBit += '0';

            }

            if(counter0 <= counter1) {

                co2Bit += '0';

            } else if(counter1 < counter0) {

                co2Bit += '1';
            }
        }
        System.out.println(oxygenBit);
        System.out.println(co2Bit);

        System.out.println(decimalOxygen = Integer.parseInt(oxygenBit, 2));
        System.out.println(decimalCo2 = Integer.parseInt(co2Bit, 2));

        System.out.println(decimalOxygen*decimalCo2);

    }
}

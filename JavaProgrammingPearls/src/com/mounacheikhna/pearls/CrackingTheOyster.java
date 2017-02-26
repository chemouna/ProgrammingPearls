package com.mounacheikhna.pearls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by m.cheikhna on 26/02/2017.
 */
public class CrackingTheOyster {

    private final int maxInt;

    private final String inputPath = "resources/crackingOyster/INPUT_CRACKING_OYSTER";
    private final String outputPath = "resources/crackingOyster/OUTPUT_CRACKING_OYSTER";

    public CrackingTheOyster(int maxInt) {
        this.maxInt = maxInt;
        if (!new File(inputPath).exists()) {
            this.setup();
        }
    }

    public void solve() {
        final BitSet bits = new BitSet(maxInt);

        //Initialize bits to false
        for (int i = 0; i < bits.size(); i++) {
            bits.set(i, false);
        }

        Scanner scan = createInputScanner();
        if (scan == null) return;

        //set bits to true
        while (scan.hasNextInt()) {
            bits.set(scan.nextInt(), true);
        }

        scan.close();

        try (final PrintWriter writer = new PrintWriter(new File(this.outputPath))) {
            //print the sorted integers
            for (int i = 0; i < bits.size(); i++) {
                if (bits.get(i)) {
                    writer.println(i);
                }
            }
            writer.flush();
            writer.close();
        } catch (final FileNotFoundException fnfex) {
            Logger.getLogger(CrackingTheOyster.class.getName()).log(Level.SEVERE, null, fnfex);
        }
    }

    private Scanner createInputScanner() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File(this.inputPath));
        } catch (final FileNotFoundException fnfex) {
            Logger.getLogger(CrackingTheOyster.class.getName()).log(Level.SEVERE, null, fnfex);
        }
        return scan;
    }

    private void setup() {
        try {
            new File(inputPath).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final int[] integers = new int[this.maxInt];

        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }

        shuffle(integers);
        final int maxValueLength = String.valueOf(maxInt - 1).length();
        try {
            try (final PrintWriter writer = new PrintWriter(inputPath)) {
                for (int i = 0; i < integers.length; i++) {
                    writer.println(formatInteger(integers[i], maxValueLength));
                }
                writer.flush();
                writer.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void shuffle(int[] integerArray) {
        final Random rand = ThreadLocalRandom.current();
        for (int i = integerArray.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int a = integerArray[index];
            integerArray[index] = integerArray[i];
            integerArray[i] = a;
        }
    }

    public static String formatInteger(final int i, final int length) {
        String result = String.valueOf(i);
        while (result.length() != length) {
            result = "0" + result;
        }
        return result;
    }

}

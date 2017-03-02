package com.mounacheikhna.pearls;

/**
 * Created by m.cheikhna on 26/02/2017.
 */
public class Pearls {

    public static void main(String[] args) {

        final int arraySizeToSort = 1000000;
        final String inf = "bit map sort for integer array of %d entries completed in %d ns";
        final Col1CrackingTheOyster oyster = new Col1CrackingTheOyster(arraySizeToSort);
        System.out.println("Programming Pearls COLUMN 1 : bit map sort for integer array");
        oyster.solve();

    }

}


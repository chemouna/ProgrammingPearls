package com.mounacheikhna.pearls;

/**
 * Created by m.cheikhna on 02/03/2017.
 */
public class ArraysUtils {

    public static int max(Integer ... arr) {
        int max = Integer.MIN_VALUE;
        for (Integer i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

}

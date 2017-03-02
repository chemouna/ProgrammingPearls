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

    /**
     * @param maxSum
     * @param v main array.
     * @param u end index.
     * @return the max summed up sub array as an array of integers that contains a copy of
     * the sub vector.array
     */
    public static int[] getSubArray(final int maxSum, int[] v, final int u) throws SubArrayNotFoundException {
        // N^2 complexity.
        for (int i = u; i > 0; i--) {
            for (int j = u; j > 0; j--) {
                if (subArraySum(v, j, i) == maxSum)
                    return java.util.Arrays.copyOfRange(v, j, i + 1);
            }
        }
        throw new SubArrayNotFoundException();
    }

    public static int subArraySum(int[] v, final int a, final int b) {
        int result = 0;
        for (int i = a; i < b + 1; i++) result += v[i];
        return result;
    }

    public static int arraySum(int[] v) {
        int result = 0;
        for (int i = 0; i < v.length; i++) result += v[i];
        return result;
    }

    public static class SubArrayNotFoundException extends Exception {
    }
}

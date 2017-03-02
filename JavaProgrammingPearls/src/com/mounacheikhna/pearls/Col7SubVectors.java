package com.mounacheikhna.pearls;

import com.mounacheikhna.pearls.ArraysUtils.SubArrayNotFoundException;
import com.mounacheikhna.pearls.StopWatch.StopWatchException;

/**
 * Created by m.cheikhna on 02/03/2017.
 */
public class Col7SubVectors {

    Col7SubVectors() {
    }

    private void runDivideAndConquer(int[] vector) {
        run(vector, "maxSumByDivideAndConquer",
            maxSumByDivideAndConquer(vector, 0, vector.length - 1));
    }

    private void runScanMaxSoFar(int[] vector)
        throws StopWatchException, SubArrayNotFoundException {
        run(vector, "runScanMaxSoFar", maxSumByScanning(vector));
    }

    private void run(int[] vector, String name, int result) {
        try {
            StopWatch.start();
            final String inf = String.format(name + " runtime=%d ns", StopWatch.stopNS());
            String output = "Max sum of sub vector.length %s = %d with algorithm %s";
            System.out.println(String.format(output, vector.length, result, inf));
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    int maxSumByScanning(int[] vector) throws SubArrayNotFoundException {
        int maxSoFar = 0, maxEndingHere = 0, tempMax = 0, endIndex = 0;

        for (int i = 1; i < vector.length; i++) {
            //Invariant: MaxEndingHere and maxSoFar are accurate for X[1..i-1]
            maxEndingHere = ArraysUtils.max(maxEndingHere + vector[i], 0);
            tempMax = ArraysUtils.max(maxSoFar, maxEndingHere);
            endIndex = tempMax > maxSoFar ? i : endIndex;
            maxSoFar = Math.max(tempMax, maxSoFar);
        }

        //why ?
        final int[] arrays = ArraysUtils.getSubArray(maxSoFar, vector, endIndex);
        return ArraysUtils.arraySum(arrays);
    }

    private int maxSumByDivideAndConquer(int[] vector, final int l, final int u) {
        int leftMax = 0, rightMax = 0, sum = 0;

        if (l > u || vector == null) return 0; // Empty array.
        if (l == u) return ArraysUtils.max(0, vector[l]);

        final int m = (l + u) / 2;

        // left side
        for (int i = m; i >= l; i--) {
            sum += vector[i];
            leftMax = ArraysUtils.max(leftMax, sum);
        }

        sum = 0;
        //right side
        for (int i = m + 1; i < u; i++) {
            sum += vector[i];
            rightMax = ArraysUtils.max(rightMax, sum);
        }

        return ArraysUtils.max(leftMax + rightMax, maxSumByDivideAndConquer(vector, l, m),
            maxSumByDivideAndConquer(vector, m + 1, u));
    }

    int maxSumByDivideAndConquer(int[] vector) {
        return maxSumByDivideAndConquer(vector, 0, vector.length - 1);
    }

    public static void main(String[] args) {
        try {
            final int[] v1 = {
                31, -41, 59, 26, -53, 58, 97, -93, -23, 84
            };
            Col7SubVectors subVectors = new Col7SubVectors();
            subVectors.runDivideAndConquer(v1);
            subVectors.runScanMaxSoFar(v1);

            final int[] v2 = {
                31, -41, 59, 26, -53, 58, 97, -93, -23, 84, -43, -54, -32, -43, -11111111, -543,
                -543, 2, 0, -543, -32, 5, 6, -54, -654, 9, 3, 5, -5432, 2, 3, 1, 0, 0, 0, 0, 1, 2,
                3, 4, -54, 0, 0, 32, 0, 1, 2, 3, 2, 1, 2, 3, -43, 0, 0, 0, -34, 100, 100, 200, -200,
                300, 400, -543, 5, 54, -43, 0, 43
            };
            subVectors.runDivideAndConquer(v2);
            subVectors.runScanMaxSoFar(v2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

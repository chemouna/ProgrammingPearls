package com.mounacheikhna.pearls;

import com.mounacheikhna.pearls.StopWatch.StopWatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by m.cheikhna on 02/03/2017.
 */
public class Col7SubVectors {

    private final int[] vector;

    private final String output = "Max sum of sub vector.length %s = %d with algorithm %s";

    public Col7SubVectors(final int[] vector) {
        this.vector = vector;
    }

    public void runDivideAndConquer() {
        try {
            StopWatch.start();
            final int r = divideAndConquer(this.vector, 0, this.vector.length - 1);
            final String inf = String.format("divideAndConquer runtime=%d ns", StopWatch.stopNS());
            System.out.println(String.format(output, this.vector.length, r, inf));
        } catch (final StopWatchException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private int divideAndConquer(int[] vector, final int l, final int u) {
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

        return ArraysUtils.max(leftMax + rightMax, divideAndConquer(vector, l, m),
            divideAndConquer(vector, m + 1, u));
    }

    public static void main(String[] args) {

        Col7SubVectors subVectors = new Col7SubVectors(new int[] {
            31, -41, 59, 26, -53, 58, 97, -93, -23, 84
        });
        subVectors.runDivideAndConquer();

        subVectors = new Col7SubVectors(new int[] {
            31, -41, 59, 26, -53, 58, 97, -93, -23, 84, -43, -54, -32, -43, -11111111,
            -543, -543, 2, 0, -543, -32, 5, 6, -54, -654, 9, 3, 5, -5432, 2, 3, 1, 0,
            0, 0, 0, 1, 2, 3, 4, -54, 0, 0, 32, 0, 1, 2, 3, 2, 1, 2, 3, -43, 0, 0, 0,
            -34, 100, 100, 200, -200, 300, 400, -543, 5, 54, -43, 0, 43
        });
        subVectors.runDivideAndConquer();


    }

}

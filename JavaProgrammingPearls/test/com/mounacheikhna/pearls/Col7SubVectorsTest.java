package com.mounacheikhna.pearls;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by m.cheikhna on 02/03/2017.
 */
public class Col7SubVectorsTest {

    @Test
    public void emptyVectorDivideAndConquerTest() throws Exception {
        final int[] vector = {};
        Col7SubVectors subVectors = new Col7SubVectors();
        Assert.assertEquals(subVectors.divideAndConquer(vector), 0);
    }

    @Test
    public void onlyNegativesVectorDivideAndConquerTest() throws Exception {
        final int[] vector = {-4, -1, -2, -9};
        Col7SubVectors subVectors = new Col7SubVectors();
        Assert.assertEquals(subVectors.divideAndConquer(vector), 0);
    }

    @Test
    public void smallVectorDivideAndConquerTest() throws Exception {
        final int[] vector = {
            31, -41, 59, 26, -53, 58, 97, -93, -23, 84
        };
        Col7SubVectors subVectors = new Col7SubVectors();
        Assert.assertEquals(subVectors.divideAndConquer(vector), 187);
    }

    @Test
    public void biggerVectorDivideAndConquerTest() throws Exception {
        final int[] vector = {
            31, -41, 59, 26, -53, 58, 97, -93, -23, 84, -43, -54, -32, -43, -11111111, -543,
            -543, 2, 0, -543, -32, 5, 6, -54, -654, 9, 3, 5, -5432, 2, 3, 1, 0, 0, 0, 0, 1, 2,
            3, 4, -54, 0, 0, 32, 0, 1, 2, 3, 2, 1, 2, 3, -43, 0, 0, 0, -34, 100, 100, 200, -200,
            300, 400, -543, 5, 54, -43, 0, 43
        };
        Col7SubVectors subVectors = new Col7SubVectors();
        Assert.assertEquals(subVectors.divideAndConquer(vector), 900);
    }

    @Test
    public void emptyVectorScanSoFarTest() throws Exception {
        final int[] vector = {};
        Col7SubVectors subVectors = new Col7SubVectors();
        Assert.assertEquals(subVectors.scanMaxSoFarMethod(vector), 0);
    }

    @Test
    public void onlyNegativesVectorScanSoFarTest() throws Exception {
        final int[] vector = {-4, -1, -2, -9};
        Col7SubVectors subVectors = new Col7SubVectors();
        Assert.assertEquals(subVectors.scanMaxSoFarMethod(vector), 0);
    }

    @Test
    public void smallVectorScanSoFarTest() throws Exception {
        final int[] vector = {
            31, -41, 59, 26, -53, 58, 97, -93, -23, 84
        };
        Col7SubVectors subVectors = new Col7SubVectors();
        Assert.assertEquals(subVectors.scanMaxSoFarMethod(vector), 187);
    }

    @Test
    public void biggerVectorScanSoFarTest() throws Exception {
        final int[] vector = {
            31, -41, 59, 26, -53, 58, 97, -93, -23, 84, -43, -54, -32, -43, -11111111, -543,
            -543, 2, 0, -543, -32, 5, 6, -54, -654, 9, 3, 5, -5432, 2, 3, 1, 0, 0, 0, 0, 1, 2,
            3, 4, -54, 0, 0, 32, 0, 1, 2, 3, 2, 1, 2, 3, -43, 0, 0, 0, -34, 100, 100, 200, -200,
            300, 400, -543, 5, 54, -43, 0, 43
        };
        Col7SubVectors subVectors = new Col7SubVectors();
        Assert.assertEquals(subVectors.scanMaxSoFarMethod(vector), 900);
    }

}

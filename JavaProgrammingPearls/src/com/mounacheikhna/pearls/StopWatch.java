package com.mounacheikhna.pearls;

/**
 * Created by m.cheikhna on 02/03/2017.
 */
public class StopWatch {

    private static boolean running = false;
    private static long startT = 0L;

    /**
     * @throws StopWatchException
     */
    public static final void start() throws StopWatchException {
        if (StopWatch.running) throw new StopWatchException();
        StopWatch.running = true;
        StopWatch.startT = System.nanoTime();
    }

    /**
     * @return elapsed time in nano seconds.
     * @throws StopWatchException
     */
    public static final long stopNS() throws StopWatchException {
        if (!StopWatch.running) throw new StopWatchException();
        StopWatch.running = false;
        return (System.nanoTime() - StopWatch.startT);
    }

    public static class StopWatchException extends Exception {
    }
}

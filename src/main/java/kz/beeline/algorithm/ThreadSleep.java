package kz.beeline.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class ThreadSleep {
    private static final int ORIGIN = 0;
    private static final int BOUND = 500;
    private static final Logger log = LogManager.getLogger(ThreadSleep.class);
    private static final Random rnd = new Random();

    public static void sleep(long step) {
        try {
            var random = rnd.nextLong(ORIGIN, BOUND);
            log.info("Thread sequence for " + step + " sleep mills: " + random);
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

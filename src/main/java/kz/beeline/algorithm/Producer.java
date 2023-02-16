package kz.beeline.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Producer implements Runnable {

    private static final int ORIGIN = 0;
    private static final int BOUND = 500;
    private static final Logger log = LogManager.getLogger(Producer.class);
    private final Printer printer;
    private final int step;

    public Producer(Printer printer, int step) {
        this.step = step;
        this.printer = printer;
    }

    @Override
    public void run() {
        int value = step;
        Random random = new Random();
        while (true) {
            log.info("value: " + value);
            printer.add(value);
            value = value + step;
            try {
                var rnd = random.nextLong(ORIGIN, BOUND);
                log.info("Thread sequence for " + step + " sleep mills: " + rnd);
                Thread.sleep(rnd);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}

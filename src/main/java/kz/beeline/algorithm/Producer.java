package kz.beeline.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Producer implements Runnable {


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
        while (true) {
            log.info("value: " + value);
            printer.add(value);
            value = value + step;
            ThreadSleep.sleep(step);
        }
    }
}

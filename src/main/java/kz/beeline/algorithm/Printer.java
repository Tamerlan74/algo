package kz.beeline.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Printer implements Runnable {

    public static final int ORIGIN = 0;
    private static final int BOUND = 10;
    private static final Logger log = LogManager.getLogger(Printer.class);
    private final ConcurrentLinkedDeque<Integer> stack;
    private final Random rnd = new Random();
    private long minStackSize;


    public Printer() {
        this.stack = new ConcurrentLinkedDeque<>();
        this.minStackSize = rnd.nextInt(ORIGIN, BOUND);
    }

    public boolean add(int numeric) {
        return stack.add(numeric);
    }

    private void print() {
        List<Integer> numerics = new ArrayList<>();
        synchronized (this) {
            while (!stack.isEmpty()) {
                numerics.add(stack.pollLast());
            }
        }
        log.info(numerics.toString());
        this.minStackSize = rnd.nextInt(ORIGIN, BOUND);
    }

    @Override
    public void run() {
        while (true) {
            if (stack.size() >= minStackSize) {
                log.info("stack min size: " + minStackSize);
                this.print();
            }
        }
    }
}

package kz.beeline.algorithm;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();

        Producer producer1 = new Producer(printer, 3);
        Producer producer2 = new Producer(printer, 5);

        new Thread(printer).start();
        new Thread(producer1).start();
        new Thread(producer2).start();

    }
}

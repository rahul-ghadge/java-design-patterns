package src.main.java.patterns.creational.singleton;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Nothing created yet. First call:");
        ApplicationLogger first = ApplicationLogger.getInstance();
        ApplicationLogger second = ApplicationLogger.getInstance();
        System.out.println("Same instance? " + (first == second));

        first.log("Application started");
        second.log("Second reference sees the same log");
        System.out.println("Messages via first : " + first.getMessages());

        // Many threads asking at once must still get exactly one instance.
        System.out.println("Requesting from 8 threads at once...");
        Map<ApplicationLogger, Boolean> seen = new IdentityHashMap<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            final int id = i;
            Thread t = new Thread(() -> {
                ApplicationLogger logger = ApplicationLogger.getInstance();
                logger.log("hello from thread " + id);
                synchronized (seen) {
                    seen.put(logger, Boolean.TRUE);
                }
            });
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Distinct instances seen: " + seen.size());
        System.out.println("Total messages logged  : " + first.messageCount());

        try {
            first.log("  ");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}

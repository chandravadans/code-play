package com.cv.codepad.concurrency.diningphilosopher;


public class DiningPhilosophers {

    public static void main(String[] args) throws Exception {

        final Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {

            Object left = forks[i];
            Object right = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(right, left); // The last philosopher picks up the right fork first
            } else {
                philosophers[i] = new Philosopher(left, right);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}

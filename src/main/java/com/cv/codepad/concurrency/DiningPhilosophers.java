package com.cv.codepad.concurrency;


public class DiningPhilosophers {

    static class Philosopher implements Runnable {
        private final Object left;
        private final Object right;

        public Philosopher(Object left, Object right) {
            this.left = left;
            this.right = right;
        }

        private void doAction(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " " + action);
            Thread.sleep(((int) (Math.random() * 100)));
        }

        public void run() {
            try {
                while (true) {
                    doAction(System.nanoTime() + ": Thinking"); // thinking
                    synchronized (left) {
                        doAction(System.nanoTime() + ": Picked up left fork");
                        synchronized (right) {
                            doAction(System.nanoTime() + ": Picked up right fork - eating"); // eating
                            doAction(System.nanoTime() + ": Put down right fork");
                        }
                        doAction(System.nanoTime() + ": Put down left fork. Returning to thinking");
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

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
                philosophers[i] = new Philosopher(right, left);
            } else {
                philosophers[i] = new Philosopher(left, right);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}

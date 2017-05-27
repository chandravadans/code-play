package com.cv.codepad.misc;

/**
 * Created by Chandravadan on 5/3/2017.
 */
public class EvenOdd {
    volatile static int i = 1;

    static class PrinterThread implements Runnable {

        private Object lock;

        public PrinterThread(Object lockObject) {
            this.lock = lockObject;
        }

        @Override
        public void run() {
            while (i < 10) {
                if (i % 2 == 0 && Thread.currentThread().getName().equals("Even")) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " - "
                                + i);
                        i++;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (i % 2 == 1 && Thread.currentThread().getName().equals("Odd")) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " - "
                                + i);
                        i++;
                        lock.notify();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object commonLock = new Object();
        Thread t1 = new Thread(new PrinterThread(commonLock));
        t1.setName("Even");
        Thread t2 = new Thread(new PrinterThread(commonLock));
        t2.setName("Odd");
        t1.start();
        t2.start();

    }
}

package com.robustwang.example.thread;

public class PrintNumber {
    private static int state = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 0) {
                                lock.wait();
                            }
                            System.out.println("A");
                            state++;

                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 1) {
                                lock.wait();
                            }
                            System.out.println("B");
                            state++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 2) {
                                lock.wait();
                            }
                            System.out.println("C");
                            state++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
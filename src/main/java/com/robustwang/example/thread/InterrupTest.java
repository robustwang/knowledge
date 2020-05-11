package com.robustwang.example.thread;
/**
 * @ClassName InterrupTest
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/5/9 14:15
 * @Version 1.0
 **/
public class InterrupTest implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                Boolean a = Thread.currentThread().isInterrupted();
                System.out.println("in run() - about to sleep for 20 seconds-------" + a);
                Thread.sleep(20000);
                System.out.println("in run() - woke up");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Boolean c = Thread.interrupted();
            Boolean d = Thread.interrupted();
            System.out.println("c=" + c);
            System.out.println("d=" + d);
        }
    }

    public static void main(String[] args) {
        InterrupTest si = new InterrupTest();
        Thread t = new Thread(si);
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");
        t.interrupt();
        System.out.println("in main() - leaving");
    }
}
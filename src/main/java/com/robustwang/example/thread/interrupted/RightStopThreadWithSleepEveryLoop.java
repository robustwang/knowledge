package com.robustwang.example.thread.interrupted;

/**
 * @ClassName rightStopThreadWithSleepEveryLoop
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/5/9 14:45
 * @Version 1.0
 **/

public class RightStopThreadWithSleepEveryLoop {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000) {
                    if (num % 100 == 0 && !Thread.currentThread().isInterrupted()) {
                        System.out.println(num + "是100的整数倍");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}

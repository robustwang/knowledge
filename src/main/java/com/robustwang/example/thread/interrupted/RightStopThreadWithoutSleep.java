package com.robustwang.example.thread.interrupted;

/**
 * @ClassName RightStopThreadWithoutSleep
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/5/9 14:29
 * @Version 1.0
 **/

public class RightStopThreadWithoutSleep implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new RightStopThreadWithoutSleep());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }

    @Override
    public void run() {
        int num = 0;
        while (num <= Integer.MAX_VALUE / 2) {
            if (!Thread.currentThread().isInterrupted() && num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务结束了。");
    }
}

package com.robustwang.example.thread.interrupted;

/**
 * @ClassName RightStopThreadWithSleep
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/5/9 14:35
 * @Version 1.0
 **/

public class RightStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
            while (num <= 300){
                if (num % 100 == 0 && !Thread.currentThread().isInterrupted()){
                    System.out.println(num + "是100的整数倍");
                }
                num++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}

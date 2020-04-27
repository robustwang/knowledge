package com.robustwang.example.aqs;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName LockSupportDemo
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/4/27 11:33
 * @Version 1.0
 **/

public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park("线程a的blocker数据");
                System.out.println("我是被线程b唤醒后的操作"+" "+Thread.currentThread().getName());
            }
        });
        a.start();

        //让当前主线程睡眠1秒，保证线程a在线程b之前执行
        Thread.sleep(1000);
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                String before = (String) LockSupport.getBlocker(a);
                System.out.println("阻塞时从线程a中获取的blocker------>" + before+" "+Thread.currentThread().getName());
                LockSupport.unpark(a);

                //这里睡眠是，保证线程a已经被唤醒了
                try {
                    Thread.sleep(1000);
                    String after = (String) LockSupport.getBlocker(a);
                    System.out.println("唤醒时从线程a中获取的blocker------>" + after+" "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        b.start();
    }
}
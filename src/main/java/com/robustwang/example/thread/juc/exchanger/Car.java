package com.robustwang.example.thread.juc.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @ClassName Car
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/4/29 16:19
 * @Version 1.0
 **/

public class Car extends Thread {

    private Exchanger<String> exchanger;

    public Car(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("Class Car "+Thread.currentThread().getName() + ": " + exchanger.exchange("Car"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.robustwang.example.thread.juc.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @ClassName Bike
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/4/29 16:20
 * @Version 1.0
 **/

public class Bike extends Thread {

    private Exchanger<String> exchanger;

    public Bike(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("Class Bike " + Thread.currentThread().getName() + ": " + exchanger.exchange("Bike"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

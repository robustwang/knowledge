package com.robustwang.example.thread.juc.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @ClassName ExchangerDemo
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/4/29 16:18
 * @Version 1.0
 **/

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Car car = new Car(exchanger);
        Bike bike = new Bike(exchanger);
        car.start();
        bike.start();
        System.out.println("Main end!");
    }


}

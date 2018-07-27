package com.robustwang.example.core;

public class WaitNotify {


    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o){
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                o.notify();
            }

        }

    }
}

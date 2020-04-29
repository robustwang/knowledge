package com.robustwang.example.thread.juc.queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @ClassName ConcurrentLinkedDequeDemo
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/4/29 17:34
 * @Version 1.0
 **/

public class ConcurrentLinkedDequeDemo {

    private static ConcurrentLinkedDeque<String> cld = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) {
        int numThread = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThread];
        for (int i = 0; i < threads.length; i++) {
            (threads[i] = new Thread(addTask(), "Thread " + i)).start();
        }
    }

    public static Runnable addTask() {
        return new Runnable() {
            @Override
            public void run() {
                int num = Runtime.getRuntime().availableProcessors();
                for (int i = 0; i < num; i++) {
                    StringBuilder item = new StringBuilder("Item ").append(i);
                    cld.addFirst(item.toString());
                    callbackAdd(Thread.currentThread().getName(), item);
                }
                callbackFinish(Thread.currentThread().getName());
            }
        };
    }

    public static void callbackAdd(String threadName, StringBuilder item) {
        StringBuilder builder = new StringBuilder(threadName).append(" added :").append(item);
        System.out.println(builder);
    }

    public static void callbackFinish(String threadName) {
        StringBuilder builder = new StringBuilder(threadName).append(" has Finished");
        System.out.println(builder);
        System.out.println(new StringBuilder("CurrentSize ").append(cld.size()));
    }
}
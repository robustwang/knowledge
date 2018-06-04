package com.robustwang.example.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author wangjun
 * @Date 2018/6/4 14:03
 */
public class ConcurrentLinkedQueueExample {

    private final static Logger logger = LoggerFactory.getLogger(ConcurrentLinkedQueueExample.class);


    /**
     * 非堵塞 消费者可能 null
     */
    public static void main(String args[]) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
        for (int i = 0; i < 2; i++) {
            Productor task = new Productor(queue);
            Thread t = new Thread(task, "生产者线程" + i);
            t.start();
        }
        for (int i = 0; i < 2; i++) {
            Consumer task = new Consumer(queue);
            Thread t = new Thread(task, "消费者线程" + i);
            t.start();
        }
    }

    static class Consumer implements Runnable {
        private ConcurrentLinkedQueue<String> queue;

        public Consumer(ConcurrentLinkedQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("消费者-->  " + queue.poll());
            }
        }
    }

    static class Productor implements Runnable {
        private ConcurrentLinkedQueue<String> queue;

        public Productor(ConcurrentLinkedQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String content = String.valueOf(System.currentTimeMillis());
                logger.info("生产者==>  " + content);
                queue.add(content);
            }
        }
    }
}
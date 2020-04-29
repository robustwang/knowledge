package com.robustwang.example.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author wangjun
 * @Date 2018/6/4 14:16
 *
 */
public class LinkedBlockingQueueExample {

    private final static Logger logger = LoggerFactory.getLogger(LinkedBlockingQueueExample.class);

    /**
     * 堵塞
     * @param args
     */
    public static void main(String args[]) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

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

    static class Productor implements Runnable {
        private LinkedBlockingQueue<String> queue;

        public Productor(LinkedBlockingQueue<String> queue) {
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

    static class Consumer implements Runnable {
        private LinkedBlockingQueue<String> queue;

        public Consumer(LinkedBlockingQueue<String> queue) {
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
                try {
                    logger.info("消费者-->  " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

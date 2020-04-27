package com.robustwang.example.threadpool;

import net.sf.ehcache.util.NamedThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadChangeDemo
 * @Description TODO
 * @Author wang.jun
 * @Date 2020/4/27 19:39
 * @Version 1.0
 **/

public class ThreadChangeDemo {

    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutor();
    }


    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10), new NamedThreadFactory("测试多线程"));
    }

    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        for (int i = 0; i < 15; i++) {
            executor.submit(() -> {
                threadPoolStatus(executor, "创建任务");
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("======================================================================");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
        }
        threadPoolStatus(executor, "改变之前");
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(10);
        threadPoolStatus(executor, "改变之后");
        Thread.currentThread().join();
    }

    private static void threadPoolStatus(ThreadPoolExecutor executor, String name) {
        LinkedBlockingQueue queue = (LinkedBlockingQueue) executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-:" +
                "核心线程数:" + executor.getCorePoolSize() +
                " 活动线程数:" + executor.getActiveCount() +
                " 最大线程数:" + executor.getMaximumPoolSize() +
                " 线程池活跃度：" + divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                " 任务完成数量:" + executor.getCompletedTaskCount() +
                " 队列大小：" + (queue.size() + queue.remainingCapacity()) +
                " 当前排队线程数:" + queue.size() +
                " 队列剩余大小：" + queue.remainingCapacity() +
                " 队列使用度：" + divide(queue.size(), queue.size() + queue.remainingCapacity()));

    }

    private static String divide(int num1, int num2) {
        return String.format("%1.2f%%", Double.parseDouble(num1 + "") / Double.parseDouble(num2 + "") * 100);
    }

}

package com.robustwang.example.management;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadManagement {

    public static void main(String[] args) {
        ThreadMXBean thread = ManagementFactory.getThreadMXBean();
        System.out.println("ThreadCount" + thread.getThreadCount());
        System.out.println("AllThreadIds:" + thread.getAllThreadIds());
        System.out.println("CurrentThreadUserTime" + thread.getCurrentThreadUserTime());
        ThreadInfo[] threadInfo = thread.getThreadInfo(thread.getAllThreadIds());
        for (ThreadInfo ti : threadInfo
        ) {
            System.out.println(ti.getThreadName());
        }

    }

}

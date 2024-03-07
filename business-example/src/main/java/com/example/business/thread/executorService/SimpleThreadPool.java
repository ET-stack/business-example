package com.example.business.thread.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className: SimpleThreadPool
 * @description: TODO 简单线程池 代码来源 https://pdai.tech/md/java/thread/java-thread-x-juc-executor-ThreadPoolExecutor.html
 * @date: 2024/3/7
 *
 * 一个简单的多线程执行场景，其中创建了一个包含5个工作线程的线程池（ExecutorService）。ExecutorService是一个接口，
 * Executors.newFixedThreadPool(5)会创建一个固定大小的线程池，该线程池始终保持5个工作线程，在任何时间点如果有超过5个任务被提交，
 * 超出的任务将在工作线程可用时排队等待执行。
 **/
public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        //换句话说，当调用 executor.isTerminated() 返回 true 时，
        // 意味着线程池已经处于关闭状态，并且所有任务（包括已提交但尚未开始的任务）都已结束，要么是正常执行完毕，
        // 要么是被取消。这对于编写多线程程序中等待所有任务完成后再继续执行后续逻辑的场景非常有用。
        // 例如，可以在循环中检查 executor.isTerminated() 是否为真，以便在所有任务结束后继续执行程序的其余部分。
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}

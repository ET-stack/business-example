package com.example.business.thread.executorService;

/**
 * @className: WorkerThread
 * @description: TODO 类描述
 * @date: 2024/3/7
 **/
public class WorkerThread  implements Runnable{
    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");

    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return this.command;
    }
}

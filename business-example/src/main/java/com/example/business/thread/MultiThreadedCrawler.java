package com.example.business.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @className: MultiThreadedCrawler
 * @description: TODO 类描述
 * @date: 2024/3/7
 **/
public class MultiThreadedCrawler {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // 存储待抓取的URL列表
        List<String> urls = new ArrayList<>();
        urls.add("https://pdai.tech/md/java/thread/java-thread-x-juc-executor-ThreadPoolExecutor.html");
        // 填充urls列表...

        // 用于存储每个下载任务的结果
        List<Future<String>> results = new ArrayList<>();

        // 提交下载任务到线程池
        for (String url : urls) {
            PageDownloader task = new PageDownloader(url);
            Future result = executor.submit(task);
            results.add(result);
        }

        // 等待所有任务完成并处理结果
        for (Future<String> future : results) {
            try {
                String content = future.get();
                // 处理页面内容，例如存储到数据库或进行数据分析
                System.out.println("Page content: " + content);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 关闭线程池
        executor.shutdown();
    }
}

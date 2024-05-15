package com.example.business.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @className: PageDownloader
 * @description: TODO 类描述
 * @date: 2024/3/7
 **/
public class PageDownloader  implements Runnable{

    private final String url;
    private volatile String pageContent;

    public PageDownloader(String url) {
        this.url = url;
    }


    @Override
    public void run() {
     try {
         URL urlObj = new URL(url);
         HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
         connection.setRequestMethod("GET");
         connection.connect();

         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
         StringBuilder sb = new StringBuilder();
         String line;
         while ((line = reader.readLine()) != null) {
             sb.append(line);
         }

         reader.close();
         connection.disconnect();
         this.pageContent = sb.toString();
     } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }
}

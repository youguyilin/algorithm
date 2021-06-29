package com.coder.yingen.algorithm;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Alex Chu on 2021/5/17.
 */
@RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
public class ProductAndConsumerBQ {
    private BlockingDeque<Integer> mque = new LinkedBlockingDeque<>(10);

    public class ProductBQ extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    mque.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产者生产了一条任务为，当前队列长度为：" + mque.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class ConsumerBQ extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    mque.take();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费这消费了一条消息，当前队列长度为： " + mque.size());
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

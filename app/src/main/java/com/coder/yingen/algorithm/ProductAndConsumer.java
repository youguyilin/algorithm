package com.coder.yingen.algorithm;

import android.media.session.MediaSession;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alex Chu on 2021/5/17.
 *
 * 生产者消费者模式，在存储端同一时刻只有一个线程读写，有5种方式可以实现
 * 1。 用 synchronized 对存储加锁，然后用object原声的wait（）和notify() 做同步
 * 2。 用concurrent.Lock,然后用condition的wait()和signal（）做同步
 * 3。直接水涌concurrent.BlockingQueue.
 * 4. 使用PipedInputStream/PipedOutputStream
 * 5. 使用信号量 semaphore
 */
public class ProductAndConsumer {
    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<>();

    public class Product extends Thread {

        @Override
        public void run() {
            while(true) {
                synchronized (queue) {
                    while (queue.size() == MAX_LEN) {
                        queue.notify();
                        System.out.println("当前队列满了");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notify();
                    System.out.println("生产者生产一条任务， 当前队列长度为： " + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        queue.notify();
                        System.out.println("队列为空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("消费者消费一条任务，当前队列长度为 ：" + queue.size());
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ProductAndConsumer pc = new ProductAndConsumer();
        Product product =  pc.new Product();
        Consumer consumer = pc.new Consumer();
        product.start();
        consumer.start();
    }

}

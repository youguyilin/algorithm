package com.coder.yingen.algorithm;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alex Chu on 2021/5/17.
 */
public class ProductAndConsumerRL {
    private final int MAX_LEN = 10;
    private Queue<Integer> mIntegerQueue = new LinkedList<>();
    private final Lock mLock = new ReentrantLock();
    private Condition mCondition = mLock.newCondition();

    public class RTProduct extends Thread {
        @Override
        public void run() {
            while (true) {
                mLock.lock();
                try {
                    while (mIntegerQueue.size() == MAX_LEN) {
                        System.out.println("当前队列满");
                        try {
                            mCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mIntegerQueue.add(1);
                    mCondition.signal();
                    System.out.println("生产者生产一条任务，当前队列长度为： " + mIntegerQueue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    mLock.unlock();
                }
            }
        }
    }

    public class RTConsumer extends Thread {
        @Override
        public void run() {
           while (true) {
               mLock.lock();
               try {
                   while (mIntegerQueue.size() ==0) {
                       System.out.println("当前队列为空");
                       try {
                           mCondition.await();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   mIntegerQueue.poll();
                   System.out.println("消费者消费了一条任务，当前任务队列长度为： " + mIntegerQueue.size());
                   try {
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               } finally {
                   mLock.unlock();
               }
           }
        }
    }

    public static void main(String[] args) {
        ProductAndConsumerRL p = new ProductAndConsumerRL();
        RTConsumer consumer = p.new RTConsumer();
        RTProduct product = p.new RTProduct();
        product.start();
        consumer.start();
    }
}

package org.yywang.concurrentbase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author yanyan.wang
 * @date 2015-04-20 20:55
 */
public class CountDownLatchDemo {

    private static ExecutorService executor= Executors.newFixedThreadPool(5);

    public static void main(String[] args){

        CountDownLatch countDownLatch=new CountDownLatch(10);

        for(int index=0;index<10;index++) {
            executor.execute(new Task(index*10,(index+1)*10,countDownLatch));
        }

        try {
            System.out.println("开始等待线程执行...");
            countDownLatch.await();
            System.out.println("全部线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static class Task implements Runnable{

        private int startIndex;

        private int count;

        private CountDownLatch countDownLatch;

        public Task(int startIndex, int count,CountDownLatch countDownLatch) {
            this.startIndex = startIndex;
            this.count = count;
            this.countDownLatch=countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId()+"执行完成。");
            countDownLatch.countDown();
        }
    }
}

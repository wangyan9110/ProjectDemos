package org.yywang.concurrentbase;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author yanyan.wang
 * @date 2015-04-12 21:01
 */
public class ProducterConsumer {

    public static void main(String[] args){
        BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(100);
        new Productor(queue).start();
        new Consumer(queue).start();
        new Consumer(queue).start();
    }

    private static class Productor extends Thread{

        private BlockingQueue<Integer> queue;

        public Productor(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for(int index=0;index<500;index++){
                try {
                    queue.put(index);
                    System.out.println(Thread.currentThread().getId()+"生产了："+index);
                    Thread.sleep((int)(Math.random()*100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer extends Thread{

        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("消费者准备就绪");
            while(true){
                try {
                    Integer number=queue.take();
                    System.out.println(Thread.currentThread().getId()+ "消费了："+number);
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

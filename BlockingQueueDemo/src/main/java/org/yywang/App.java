package org.yywang;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       BlockingQueue<Product> queue=new ArrayBlockingQueue<Product>(1);
       Producer product=new Producer(queue,1);
       Producer product2=new Producer(queue,2);
       Consumer consumer1=new Consumer(queue,100);
       Consumer consumer2=new Consumer(queue,300);
        new Thread(product).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
      //  new Thread(product2).start();
    }
}

class Producer implements Runnable {

    private final BlockingQueue<Product> queue;

    private int id;

    public Producer(BlockingQueue<Product> queue,int id){
        this.queue=queue;
        this.id=id;
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<30;i++){
                queue.put(new Product(i,this.id));
                Thread.sleep(this.id);
            }
        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}

class Product {

    private int id;

    private int productId;

    public Product(int id,int productId){
        this.id=id;
        this.productId=productId;
    }

    public void say(int cuId){
        System.out.println(this.id + "say hello! the product is "+this.productId+"the consumer is "+cuId);
    }
}

class Consumer implements Runnable{
    private final BlockingQueue<Product> queue;

    private int id;

    public Consumer(BlockingQueue<Product> queue,int id){
        this.queue=queue;
        this.id=id;
    }

    @Override
    public void run() {
        try{
        while (true){
            Thread.sleep(300);
            consume(queue.take(),this.id);
        }}catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }

    void consume(Product product,int id){
        product.say(id);
    }
}
package org.yywang.spring;

public class MyJob {

    public void process(){
        System.out.println("处理Job.."+Thread.currentThread().getId());
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void process1(){
        System.out.println("处理Job1.."+Thread.currentThread().getId());
    }
}

package org.yywang.concurrentbase;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author yanyan.wang
 * @date 2015-04-12 20:08
 */
public class CollectionMap {

    public static void main(String[] args) {

        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
        CountDownLatch countDownLatch=new CountDownLatch(2);
        new Test(map,countDownLatch).start();
        new Test(map,countDownLatch).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iterator iter=map.keySet().iterator();
        while(iter.hasNext()){
            Integer key=(Integer)iter.next();
            System.out.println(map.get(key));
        }

    }

    private static class Test extends Thread {

        private ConcurrentMap<Integer, String> map;

        private CountDownLatch countDownLatch;


        public Test(ConcurrentMap<Integer, String> map,CountDownLatch countDownLatch) {
            this.map = map;
            this.countDownLatch=countDownLatch;
        }

        @Override
        public void run() {
            for (int index = 1; index < 10; index++) {
                map.putIfAbsent(index, Thread.currentThread().getId()+"当前值：" + index);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.countDown();
        }
    }
}

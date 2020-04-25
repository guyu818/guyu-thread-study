package com.guyu.gaoji;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Des 测试Lock
 * @Author guyu
 * @Date 2020/3/29 22:03
 * @Param 
 * @Return 
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2=new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}
class TestLock2 implements Runnable{

    int ticketNums=10;

    //定义lock锁
    private final ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try{
                lock.lock();//加锁
                if (ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }finally {
                lock.unlock();//解锁
            }

        }
    }
}

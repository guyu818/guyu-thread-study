package com.guyu.threadstate;

import com.guyu.thread.TestThread04;

/**
 * @Des 线程休眠sleep
 * @Author guyu
 * @Date 2020/3/29 10:17
 * @Param
 * @Return
 */
//摸拟网络延时:放大线程的不安全性
public class TestSleep implements Runnable{
    //一共十张火车票
    private int ticketNums=15;

    @Override
    public void run() {
        while (true){
            if(ticketNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----》拿到了第"+ticketNums--+"票");
        }

    }

    public static void main(String[] args) {
        //
        TestSleep testThread04=new TestSleep();


        new Thread(testThread04,"小明").start();
        new Thread(testThread04,"谷雨").start();
        new Thread(testThread04,"黄牛党").start();
    }
}

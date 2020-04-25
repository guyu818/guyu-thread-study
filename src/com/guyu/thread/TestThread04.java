package com.guyu.thread;
/**
 * @Des 多线程操作一个对象，并发问题
 * @Author guyu
 * @Date 2020/3/28 20:13
 * @Param
 * @Return
 */
//抢火车票
//发现问题：多个线程操作同一个资源情况下，线程不安全，数据紊乱
public class TestThread04 implements Runnable{
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
        TestThread04 testThread04=new TestThread04();


        new Thread(testThread04,"小明").start();
        new Thread(testThread04,"谷雨").start();
        new Thread(testThread04,"黄牛党").start();
    }
}

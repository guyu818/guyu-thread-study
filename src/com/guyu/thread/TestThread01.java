package com.guyu.thread;
/**
 * @Des  创建线程方法1：继承thread类，重写里面的run方法，调用start开启线程
 * @Author guyu
 * @Date 2020/3/28 17:23
 * @Param 
 * @Return 
 */
//总结：线程开启不一定立即执行，由cpu调度执行
public class TestThread01 extends Thread {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我是子线程"+i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        //创建一个线程对象
        TestThread01 thread01=new TestThread01();

        //调用start方法开启,执行结果，主线程和子线程可能会交替执行
        thread01.start();
//        thread01.run(); 如果调用run的话，那么子线程先执行，子线程执行完之后，主线程才会执行*********8

        for (int i = 0; i < 200; i++) {
            System.out.println("我是主线程，我正在和子线程一块执行"+i);
        }
    }
}

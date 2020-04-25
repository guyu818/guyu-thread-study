package com.guyu.threadstate;

public class TestPriority {

    public static void main(String[] args) {
        //主线程默认有限级启动
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());

        MyPriority myPriority=new MyPriority();

        Thread t1=new Thread(myPriority);
        Thread t2=new Thread(myPriority);
        Thread t3=new Thread(myPriority);
        Thread t4=new Thread(myPriority);
        Thread t5=new Thread(myPriority);
        Thread t6=new Thread(myPriority);

        //先设置优先级，然后再启动
        //总结：*****优先级高的不一定先执行，只不过执行的概率高一些
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY); //MAX_PRIORITY=10最高级
        t4.start();

//        t5.setPriority(-1);    报错
//        t5.start();

//        t6.setPriority(11);   报错
//        t6.start();


    }
}
class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"----》"+Thread.currentThread().getPriority());
    }
}

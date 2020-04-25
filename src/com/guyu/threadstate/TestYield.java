package com.guyu.threadstate;
/**
 * @Des 测试礼让线程
 * @Author guyu
 * @Date 2020/3/29 12:32
 * @Param
 * @Return
 */
//礼让不一定成功，看CPU心情
public class TestYield {
    public static void main(String[] args) {
        MyYeild myYeild=new MyYeild();

        new Thread(myYeild,"a").start();
        new Thread(myYeild,"b").start();
    }
}
class MyYeild implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"+线程开始执行");
        Thread.yield();             //线程礼让
        System.out.println(Thread.currentThread().getName()+"+线程执行完毕");
    }
}

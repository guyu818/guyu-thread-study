package com.guyu.threadstate;
/**
 * @Des 线程停止
 * @Author guyu
 * @Date 2020/3/29 9:57
 * @Param
 * @Return
 */
//测试stop
    //1.建议正常停止----》利用次数，不建议死循环
    //2.建议使用标志位---》设置一个标志位
    //3.不要使用stop或者destroy等过时或者JDK不推荐的使用方法

public class TestStop implements Runnable{

    //设置一个标志位
    private boolean flag=true;

    @Override
    public void run() {
        int i=0;
        while (flag) {
            System.out.println("子线程Runn》》》》》》"+i++);
        }
    }
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {

        TestStop testStop=new TestStop();
        Thread thread=new Thread(testStop);
        thread.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("主线程-》》》"+i);
            if(i==900){
                //调用子线程的stop方法，停止线程
                testStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }
}

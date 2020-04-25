package com.guyu.thread;
/**
 * @Des 创建线程的第二种方法：实现Runnbale接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
 * @Author guyu
 * @Date 2020/3/28 20:06
 * @Param 
 * @Return 
 */
public class TestThread03 implements Runnable {

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我是Runnable实现的子线程："+i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口实现类对象
        TestThread03 testThread03=new TestThread03();

        //创建线程体对象，通过线程对象开启我们的线程，代理
//        Thread thread=new Thread(testThread03);
//        thread.start();
        //上面的两步合成一步
        new Thread(testThread03).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我是主线程："+i);
        }
    }


}

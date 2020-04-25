package com.guyu.threadstate;

/**
 * @Des 线程插队
 * @Author guyu
 * @Date 2020/3/29 14:43
 * @Param
 * @Return
 */
//摸拟插队
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("VIP线程来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin=new TestJoin();
        Thread thread=new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if(i==200){
                thread.join();
            }
            System.out.println("main主线程"+i);
        }
    }
}

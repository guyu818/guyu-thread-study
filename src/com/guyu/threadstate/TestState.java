package com.guyu.threadstate;

/**
 * @Des 观察线程的状态
 * @Author guyu
 * @Date 2020/3/29 14:53
 * @Param
 * @Return
 */
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("我正在执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("////////");
        });

        //观察线程的状态
        Thread.State state=thread.getState();
        System.out.println(state);          //NEW，还没启动

        //观察启动后
        thread.start();                     //穷的那个线程
        state=thread.getState();
        System.out.println(state);          //RUN

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state=thread.getState();        //更新状态
            System.out.println(state);      //输出状态
        }


    }
}

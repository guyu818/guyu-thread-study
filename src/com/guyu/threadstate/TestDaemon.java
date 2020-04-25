package com.guyu.threadstate;

/**
 * @Des 测试守护线程
 * @Author guyu
 * @Date 2020/3/29 15:45
 * @Param 
 * @Return 
 */
public class TestDaemon {
    public static void main(String[] args) {

        You you=new You();
        God god=new God();

        Thread thread=new Thread(god);
        thread.setDaemon(true);     //设置为守护线程，默认为用户线程。。。。。。

        thread.start();             //上帝守护线程开启

        new Thread(you).start();



    }
}
//上帝
class God implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}
//你
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("=========goodbye ! world !=========");
    }
}

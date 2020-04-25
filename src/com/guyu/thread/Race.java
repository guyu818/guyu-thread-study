package com.guyu.thread;
/**
 * @Des 摸拟龟兔赛跑
 * @Author guyu
 * @Date 2020/3/28 21:07
 * @Param
 * @Return
 */
public class Race implements Runnable {

    //声明为静态变量，保证只有一个胜者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            if(gameOver(i)){
                break;
            }
//            让兔子睡眠
            if (Thread.currentThread().getName()=="兔子" && i%10==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"----》跑了第"+i+"步");
        }
    }
    public boolean gameOver(int steps){
        if(winner!=null){
            return true;
        }
        if(steps>=100){
            winner=Thread.currentThread().getName();
            System.out.println("获胜者是---》》"+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race=new Race();

        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}

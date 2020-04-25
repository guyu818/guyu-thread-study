package com.guyu.syn;

/**
 * @Des 不安全的买票
 * @Author guyu
 * @Date 2020/3/29 20:26
 * @Param
 * @Return
 */
//三大案例1：不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station=new BuyTicket();

        new Thread(station,"谷大雨").start();
        new Thread(station,"谷文聪").start();
        new Thread(station,"黄牛党").start();
    }
}

class BuyTicket implements Runnable{
    //票
    private int ticketNums=10;
    boolean flag=true;      //外部停止方式
    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //synchronized同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNums<=0){
            flag=false;
            return ;
        }
        //摸拟延时
        Thread.sleep(1000);

        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }


}

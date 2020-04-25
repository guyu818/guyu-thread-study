package com.guyu;

/**
 * @Des 死锁
 * @Author guyu
 * @Date 2020/3/29 21:47
 * @Param 
 * @Return 
 */
//死锁：多个线程互相抱着自己的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1=new Makeup(0,"灰姑凉");
        Makeup g2=new Makeup(1,"白雪公主");

        g1.start();
        g2.start();
    }
}
//口红
class Lipstick{

}
//镜子
class Mirror{

}

class Makeup extends Thread{
    //需要的资源只有一份，用static保证只有一份
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();

    int choice;//选择
    String girlName;//女孩的名字

    Makeup(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆,摸拟死锁，互相持有对方的资源
    private void makeup() throws InterruptedException {
        if (choice==0){
            synchronized (lipstick){//获取口红的锁
                System.out.println(this.girlName+"获取口红的锁");
                Thread.sleep(1000);
                //如果把下面这一段的上面这个锁拿出来，就可以解决死锁问题
                synchronized (mirror){//一秒获取镜子
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }
        }else{
            synchronized (mirror){//获取镜子的锁
                System.out.println(this.girlName+"获取镜子的锁");
                Thread.sleep(2000);
                synchronized (lipstick){//一秒获取口红
                    System.out.println(this.girlName+"获得口红的锁");
                }
            }
        }
    }
}

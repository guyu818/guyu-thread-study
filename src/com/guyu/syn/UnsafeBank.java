package com.guyu.syn;

/**
 * @Des 不安全的取钱
 * @Author guyu
 * @Date 2020/3/29 20:37
 * @Param
 * @Return
 */
//不安全的取钱
    //两个人去银行取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account=new Account(1000,"结婚基金");

        Drawing you=new Drawing(account,50,"你");
        Drawing wife=new Drawing(account,100,"wife");

        you.start();
        wife.start();

    }

}
//账户
class Account{
    int money;  //余额
    String name;//卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
//银行：摸拟取款
class Drawing extends Thread{
    Account account;//账户
    int drawingMoney;//取了多少钱
    int nowMoney;   //手里还剩多少钱

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    //取钱

    @Override
    //如果只在这里加锁的话不行，因为这里的共相资源为账户，这里只是把银行给锁住了，应该将账户锁住
    public void run() {
        synchronized (account){
            //判断有没有钱
            if (account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够了，取不了");
                return ;
            }

            //摸拟延时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=余额-你取的钱
            account.money=account.money-drawingMoney;

            //你手里的钱
            nowMoney=nowMoney+drawingMoney;

            System.out.println(account.name+"余额为"+account.money);
            //Thread.currentThread().getName()=this.getName()，因为本类继承了Thread类，所以这两个方式一样
            System.out.println(this.getName()+"手里的钱"+nowMoney);

        }


    }
}



package com.guyu.staticproxy;
/**
 * @Des 静态代理的举例
 * @Author guyu
 * @Date 2020/3/29 9:25
 * @Param
 * @Return
 */
//静态代理模式总结
    //真实对象和代理对象都要实现同一个接口
    //代理对象要代理真实角色，实现过程中需要把真实对象传进去
    //好处，代理对象可以做好多真实对象做不了的事
    //真实对象只需要做自己的
//线程底部实现原理就是静态代理****************************************为什么这么说呢？看下面的代码
public class StaticProxy {
    public static void main(String[] args) {


//        WeddingCompany weddingCompany=new WeddingCompany(new You());
//        weddingCompany.HappyMarry();
        //为什么说线程的原理也是静态代理模式呢，看下面的举例
        //首先Thread是实现的runnable接口的，而他里面lambda表达式创建的对象也是实现了Runnable接口的，他和WeddingCompany非常相似，

        //这里面用了一个lambda表达式，为了简化
        new Thread(()-> System.out.println("我爱你")).start();

        new WeddingCompany(new You()).HappyMarry();

    }
}
interface Marry{
    //人间四大喜事
        //久旱逢甘露
        //他乡遇故知
        //洞房花烛夜
        //金榜题名时
    void HappyMarry();
}
//真实角色，你去结婚
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("我要结婚了，超开心");
    }
}
//代理对象，帮助你结婚
class WeddingCompany implements Marry{
    //代理谁--》》真实目标角色
    private Marry target;

    public WeddingCompany(Marry target){
        this.target=target;
    }
    @Override
    public void HappyMarry() {
        before();                   //结婚之前，
        this.target.HappyMarry();   //真实对象干的事。
        after();                    //  结婚之后
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}

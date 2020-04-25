package com.guyu.LambDa;
/**
 * @Des lambda表达式的简化
 * @Author guyu
 * @Date 2020/3/28 22:57
 * @Param 
 * @Return 
 */


public class LambdaTest2 {
    public static void main(String[] args) {
//        Runnable的源码****************************
//        下面可以看出Runnable接口也是函数式接口所以为了简化可以使用lambda表达式
//        @FunctionalInterface
//        public interface Runnable {
//            /**
//             * When an object implementing interface <code>Runnable</code> is used
//             * to create a thread, starting the thread causes the object's
//             * <code>run</code> method to be called in that separately executing
//             * thread.
//             * <p>
//             * The general contract of the method <code>run</code> is that it may
//             * take any action whatsoever.
//             *
//             * @see     java.lang.Thread#run()
//             */
//            public abstract void run();
//        }

        ILove love=null;

//        love=(int a,int b)->{
//            System.out.println("带参数的lambda表达式"+a+b);
//        };
//         //简化
//        love=(a,b)->{
//            System.out.println("带参数的lambda表达式"+a+b);
//        };
//      //当函数里面只有一行的时候可以这么写，否则就要带{}
        love=(a,b)->System.out.println("带参数的lambda表达式"+a+b);
        love.love(520,521);
        //总结：
            //lambda表达式只能有一行代码才能化简成一行，如果多行，就需要加大括号
            //前提是接口为函数式接口
            //多个参数也可以去掉函数类型，要去掉就全去掉，必须加上括号
    }
}
interface ILove{
    void love(int a,int b);
}
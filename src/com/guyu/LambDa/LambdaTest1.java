package com.guyu.LambDa;
/**
 * @Des 推导lambda表达式
 * @Author guyu
 * @Date 2020/3/28 22:22
 * @Param 
 * @Return 
 */
public class LambdaTest1 {
    //3.静态内部实现类
    static class Like1 implements ILike{
        @Override
        public void lambda() {
            System.out.println("内部实现类，i like lambda1");
        }
    }

    public static void main(String[] args) {
        //外部实现类
        ILike like=new Like();
        like.lambda();

        //内部实现类
        like=new Like1();
        like.lambda();
        //4.局部内部类
        //2.实现类
        class Like2 implements ILike{
            @Override
            public void lambda() {
                System.out.println("局部实现类，i like lambda2");
            }
        }
        like=new Like2();
        like.lambda();

        //5.匿名内部类
        like=new ILike() {
            @Override
            public void lambda() {
                System.out.println("匿名内部类,i like lambda3");
            }
        };
        like.lambda();

        //5.lambda表达式,相当于把局部内部类的主题部分粘贴过来了
        like=()-> {
            System.out.println("lambda表达式,i like lambda4");
        };

        like.lambda();
    }



}
//1.接口式函数
interface ILike{
    void lambda();
}
//2.实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("外部实现类，i like lambda");
    }
}



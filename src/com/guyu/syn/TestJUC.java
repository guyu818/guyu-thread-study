package com.guyu.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Des 测试JUC安全类型的集合
 * @Author guyu
 * @Date 2020/3/29 21:16
 * @Param 
 * @Return 
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }

}

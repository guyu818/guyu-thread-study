package com.guyu.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Des 不安全的线程
 * @Author guyu
 * @Date 2020/3/29 20:58
 * @Param
 * @Return
 */
//结果分析，为什么最后结果小于10000，原因是可能插入的时候两个线程同时操作导致插入的数据覆盖了
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        //延时放大问题
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //打印数量
        System.out.println(list.size());
    }
}

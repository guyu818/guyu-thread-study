package com.guyu.threadstate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Des 模拟倒计时
 * @Author guyu
 * @Date 2020/3/29 10:22
 * @Param
 * @Return
 */
public class TestSleep2 {
    public static void main(String[] args) throws InterruptedException {
//        tenDown();
        //打印系统时间
        Date startTime=new Date(System.currentTimeMillis());//获取当前时间注意，是Java.util包下的date

        while (true) {
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime=new Date(System.currentTimeMillis());//更新当前时间

        }

    }

    // 模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num=10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0){
                break;
            }
        }
    }
}

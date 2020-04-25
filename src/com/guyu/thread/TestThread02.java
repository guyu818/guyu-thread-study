package com.guyu.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Des 练习多线程，实现线程同步下载图片
 * @Author guyu
 * @Date 2020/3/28 17:55
 * @Param 
 * @Return 
 */
//public class TestThread02 extends Thread{
public class TestThread02 implements Runnable{
    private String url;
    private String name;

    public TestThread02(String url,String name){
        this.url=url;
        this.name=name;
    }
    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
    }

    public static void main(String[] args) {
        TestThread02 thread01=new TestThread02("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1035415831,1465727770&os=2036467054,2328224179&simid=4030878874,470441821&pn=0&rn=1&di=8250&ln=1717&fr=&fmq=1585390051020_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fa3.att.hudong.com%2F68%2F61%2F300000839764127060614318218_950.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","1.jpg");
        TestThread02 thread02=new TestThread02("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1312059974,1893880587&os=1089612698,2972884392&simid=0,0&pn=4&rn=1&di=151170&ln=1717&fr=&fmq=1585390051020_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=11&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F31%2F20160731101714_NsALZ.thumb.700_0.jpeg&rpstart=0&rpnum=0&adpicid=0&force=undefined","2.jpg");
        TestThread02 thread03=new TestThread02("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2534506313,1688529724&os=1097436471,408122739&simid=3354786982,133358663&pn=1&rn=1&di=179520&ln=1717&fr=&fmq=1585390051020_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","3.jpg");

        new Thread(thread01).start();
        new Thread(thread02).start();
        new Thread(thread03).start();
//        //他们同时执行不一定1先下载完
//        thread01.start();
//        thread02.start();
//        thread03.start();
    }
}
//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader出现问题");
        }
    }
}
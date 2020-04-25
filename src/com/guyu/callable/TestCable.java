package com.guyu.callable;

import com.guyu.thread.TestThread02;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @Des 线程创建方式三：实现callable接口创建
 * @Author guyu
 * @Date 2020/3/28 21:13
 * @Param 
 * @Return 
 */
/*
这种方式的好处
1.可有返回值
2.可以抛出异常
 */
public class TestCable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCable(String url,String name){
        this.url=url;       //网络图片地址
        this.name=name;     //图片保存的文件名字
    }
    @Override
    public Boolean call() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCable thread01=new TestCable("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1035415831,1465727770&os=2036467054,2328224179&simid=4030878874,470441821&pn=0&rn=1&di=8250&ln=1717&fr=&fmq=1585390051020_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fa3.att.hudong.com%2F68%2F61%2F300000839764127060614318218_950.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","1.jpg");
        TestCable thread02=new TestCable("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1312059974,1893880587&os=1089612698,2972884392&simid=0,0&pn=4&rn=1&di=151170&ln=1717&fr=&fmq=1585390051020_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=11&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F31%2F20160731101714_NsALZ.thumb.700_0.jpeg&rpstart=0&rpnum=0&adpicid=0&force=undefined","2.jpg");
        TestCable thread03=new TestCable("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2534506313,1688529724&os=1097436471,408122739&simid=3354786982,133358663&pn=1&rn=1&di=179520&ln=1717&fr=&fmq=1585390051020_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","3.jpg");

        //创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(thread01);
        Future<Boolean> r2 = ser.submit(thread02);
        Future<Boolean> r3 = ser.submit(thread03);

        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdown();

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

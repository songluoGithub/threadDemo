package createThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 13:59
 * 线程实战 使用多线程下载图片
 */
public class TestThreadImgDown implements Runnable{

    //网络图片地址
    private String url;

    //保存的文件名
    private String fileName;

    public TestThreadImgDown(String url,String fileName){
        this.url = url;
        this.fileName = fileName;
    }


    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,fileName);
        System.out.println("下载了文件=====》"+fileName);
    }

    public static void main(String[] args) {
        TestThreadImgDown imgDown1 = new TestThreadImgDown("http://img.crawler.qq.com/lolwebschool/0/JAutoCMS_LOLWeb_38b05cbbe6239800e43e53ec85086958/0","img11");
        TestThreadImgDown imgDown2 = new TestThreadImgDown("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1942163519,996753909&fm=26&gp=0.jpg","img22");
        TestThreadImgDown imgDown3 = new TestThreadImgDown("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3430555835,1599638525&fm=26&gp=0.jpg","img33");

        Thread thread1 = new Thread(imgDown1);
        Thread thread2 = new Thread(imgDown2);
        Thread thread3 = new Thread(imgDown3);

        // 执行结果不是按照编码顺序执行，说明cpu自己调度线程，不是由程序本身决定
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String fileName){
        try {
            // 拷贝一个URL变成一个文件
            FileUtils.copyURLToFile(new URL(url),new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader()方法出现问题");
        }
    }
}
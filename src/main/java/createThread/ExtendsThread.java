package createThread;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 13:26
 * 创建线程的第一种方式  继承Thread  重写run方法
 */
public class ExtendsThread extends Thread{

    @Override
    public void run() {
        System.out.println("执行线程run方法");
    }

    public static void main(String[] args) {
        ExtendsThread thread = new ExtendsThread();
        thread.start();
    }
}
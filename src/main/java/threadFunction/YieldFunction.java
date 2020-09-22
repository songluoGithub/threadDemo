package threadFunction;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 15:48
 * 线程礼让
 */
public class YieldFunction {
    public static void main(String[] args) {
        Myyield myyield = new Myyield();

        Thread thread1 = new Thread(myyield,"线程1");
        Thread thread2 = new Thread(myyield,"线程2");

        thread1.start();
        thread2.start();
    }
}

class Myyield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程执行A步骤");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程执行B步骤");
    }
}
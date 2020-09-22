package threadFunction;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 16:12
 * 线程优先级
 */
public class PriorityFuntion{
    public static void main(String[] args) {
        MyPriority myPriority = new MyPriority();

        Thread thread1 = new Thread(myPriority,"t1");
        Thread thread2 = new Thread(myPriority,"t2");
        Thread thread3 = new Thread(myPriority,"t3");
        Thread thread4 = new Thread(myPriority,"t4");
        Thread thread5 = new Thread(myPriority,"t5");
        Thread thread6 = new Thread(myPriority,"t6");
        Thread thread7 = new Thread(myPriority,"t7");
        Thread thread8 = new Thread(myPriority,"t8");

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();

        thread3.setPriority(3);
        thread3.start();

        thread4.setPriority(Thread.NORM_PRIORITY);
        thread4.start();

        thread5.setPriority(7);
        thread5.start();

        thread6.setPriority(2);
        thread6.start();

//        thread7.setPriority(-1);
//        thread7.start();
//
//        thread8.setPriority(11);
//        thread8.start();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程运行");
    }
}

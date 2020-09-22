package createThread;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 13:42
 * 创建线程的第二种方法  implements Runnable接口  重写run方法
 */
public class ImplementRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("执行线程run方法");
    }

    public static void main(String[] args) {
        ImplementRunnable runnable = new ImplementRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

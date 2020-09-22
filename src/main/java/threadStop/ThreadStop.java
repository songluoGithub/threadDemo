package threadStop;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 15:27
 * 线程停止   这里说的停止是正常停止，而不是调用stop方法停止
 */
public class ThreadStop implements Runnable{
    //  线程停止标识
    Boolean flag = true;


    @Override
    public void run() {
        while (flag){
            System.out.println("线程执行中====");
        }
    }

    public void stop(){
        flag = false;
    }

    public static void main(String[] args) {
        ThreadStop threadStop = new ThreadStop();
        Thread thread = new Thread(threadStop);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程执行中====>"+i);
            if (i == 900){
                threadStop.stop();
            }
        }
    }
}

package daemon;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 16:27
 * 守护线程
 */
public class DaemonThread {
    public static void main(String[] args) {
        God god = new God();
        Person person = new Person();

        Thread godThread = new Thread(god);
        godThread.setDaemon(true);
        godThread.start();

        Thread personThread = new Thread(person);
        personThread.start();
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("上帝守护你");
        }
    }
}

class Person implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程执行");
        }
    }
}

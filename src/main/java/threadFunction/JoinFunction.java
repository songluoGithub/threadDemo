package threadFunction;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 15:53
 * join线程插队  线程vip插队,待此线程执行完成后，再执行其他线程，其他线程阻塞
 */
public class JoinFunction implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("线程执行==》"+i);
        }
    }

    public static void main(String[] args) throws Exception{
        JoinFunction joinFunction = new JoinFunction();
        Thread thread = new Thread(joinFunction);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程执行===》"+i);
            if (i == 400){
                thread.join();
            }
        }
    }
}

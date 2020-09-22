package threadFunction;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 16:01
 * status 线程状态
 */
public class StatusFunction {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("子线程结束====");
        });

        System.out.println(thread.getState());

        thread.start();

        System.out.println(thread.getState());

        while (thread.getState().TERMINATED != thread.getState()){
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
    }
}

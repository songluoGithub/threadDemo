package safaThreadDemo;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 16:38
 * 买票线程安全问题
 * 出现如下问题
 * 1.同一张票可被多人抢购
 * 2.票数出现负数的情况
 */
public class BuyTicketDemo {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        Thread thread1 = new Thread(buyTicket,"二逼的我们");
        Thread thread2 = new Thread(buyTicket,"苦逼的你们");
        Thread thread3 = new Thread(buyTicket,"可恶的黄牛");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class BuyTicket implements Runnable{

    private static int num = 10;
    private Boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try {
                buy();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @throws InterruptedException
     */
    private synchronized void buy() throws InterruptedException {
        // 判断是否有票
        if (num <= 0){
            System.out.println("票已售尽");
            flag = false;
            return;
        }
        //Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"已经抢到一张票："+num--);
    }
}

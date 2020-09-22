package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 22:04
 * lock的应用
 */
public class LockDemo {
    public static void main(String[] args) {
        BuyTicket ticket1 = new BuyTicket();
        BuyTicket ticket2 = new BuyTicket();
        BuyTicket ticket3 = new BuyTicket();

        new Thread(ticket1,"张三").start();
        new Thread(ticket1,"李四").start();
        new Thread(ticket1,"王五").start();
    }
}

class BuyTicket implements Runnable{
    int num = 10;
    Boolean flag = true;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try{
                Buy();
            }catch (Exception e){
                System.out.println(e.getMessage());
            } finally {
                lock.unlock();
            }
        }
    }

    public void Buy() throws InterruptedException {
        if (num <= 0){
            System.out.println("票已售完");
            flag = false;
        }else {
            //Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"==抢票成功=="+num--);
        }
    }
}
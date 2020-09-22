package ThreadCommunication;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 23:13
 * 线程通信信号灯法 标志位解决
 * 生产者-->演员  消费者-->观众  产品-->节目
 */
public class ThreadFlagModule {
    public static void main(String[] args) {
        TV tv = new TV();
        Player player = new Player(tv);
        Watcher watcher = new Watcher(tv);

        player.start();
        watcher.start();
    }

}

// 生产者 演员
class Player extends Thread{
    private TV tv;
    public Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                try {
                    tv.play("芒果TV");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    tv.play("抖音生活");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

// 消费者  观众
class Watcher extends Thread{
    private TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                tv.watch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 产品  节目
class TV{
    // 演员表演，观众等待
    // 观众观看，演员等待
    String voice; // 表演的节目
    Boolean flag = true;

    //表演
    public synchronized void play(String voice) throws InterruptedException {
        // flag=false代表观众还没有观看,演员先等待
        if (!flag){
            this.wait();
        }
        System.out.println("演员表演了："+voice);
        // 通知观众观看
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch() throws InterruptedException {
        if (flag){
            this.wait();
        }
        System.out.println("观众观看了："+this.voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}


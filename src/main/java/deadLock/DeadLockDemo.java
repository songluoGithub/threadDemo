package deadLock;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 21:42
 * 模拟死锁的场景
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        MakeUp makeUp1 = new MakeUp(0,"灰姑娘");
        MakeUp makeUp2 = new MakeUp(1,"白雪公主");

        makeUp1.start();
        makeUp2.start();
    }
}

// 口红
class Lipstick{

}

// 镜子
class Mirror{

}

// 化妆
class MakeUp extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    // 0 选择口红  1 镜子
    int choice;
    // 镜子
    String girlName;

    public MakeUp(int choice,String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeUp() throws InterruptedException {
        if (choice == 0){
            synchronized (lipstick){
                System.out.println(girlName+"获得了口红锁");
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(girlName+"获得了镜子");
                }
            }
        }else {
            synchronized (mirror){
                System.out.println(girlName+"获得了镜子锁");
                Thread.sleep(2000);
                synchronized (lipstick){
                    System.out.println(girlName+"获得了口红锁");
                }
            }
        }
    }
}
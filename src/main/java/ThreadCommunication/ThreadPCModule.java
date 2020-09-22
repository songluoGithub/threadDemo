package ThreadCommunication;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 22:35
 * 生产者消费者模型-->利用缓冲去解决:管程法
 * 角色   生产者  消费者  中间容器  产品
 */
public class ThreadPCModule {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);

        producer.start();
        consumer.start();
    }
}

// 生产者
class Producer extends Thread{
    SynContainer container;
    public Producer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产者生产了==>"+i+"只鸡");
            try {
                container.push(new Chicken(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Chicken chicken = container.pop();
                System.out.println("消费者消费了鸡"+chicken.id);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

// 产品
class Chicken{
    int id;
    public Chicken(int id){
        this.id = id;
    }
}

// 缓冲区容器
class SynContainer{
    // 需要定义一个容器
    Chicken[] chickens = new Chicken[10];

    // 容器大小
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) throws InterruptedException {
        /**
         * wait()表示持有对象锁的线程准备释放对象锁权限和让出 cpu 资源并进入等待状态。
         * 如果有多个消费者，比如X1，X2，X3，假如此时X1，X2，X3都处于wait状态，这时
         * 容量为0了生产者拿到锁，生产者生产了1个资源让出锁，X1拿到锁消费完之后容量又
         * 刚好为0，然后X1释放锁notifyAll通知JVM去唤醒所有竞争Container对象锁的线程，
         * 如果这个锁被X2拿到，那么就会导致0--出现数组下标越界的问题，解决方案暂时只想
         * 到把消费的if(index <=0)换成while就是让消费者线程被唤醒的时候不要立刻执行下面的代码，而是再去判断当前容量。
         */
        while (chickens.length == count){
            // 放满了，需要通知消费者消费 生产者等待
            this.wait();
        }
        // 容器可以继续放
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized Chicken pop() throws InterruptedException {
        Chicken chicken = null;
        while (count == 0){
            // 消费者等待  通知生产者生产
            this.wait();
        }
        // 从容器中消费产品
        count--;
        chicken = chickens[count];
        // 通知生产者生产
        this.notifyAll();
        return chicken;
    }
}
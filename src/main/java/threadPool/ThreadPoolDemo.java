package threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 23:34
 * 线程池使用测试
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建服务
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 执行线程方法
        service.execute(new ThreadDemo());

        // 关闭连接
        service.shutdown();
    }
}

class ThreadDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("调用线程方法");
    }
}
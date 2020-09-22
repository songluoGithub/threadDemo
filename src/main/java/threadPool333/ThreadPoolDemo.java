package threadPool333;

import java.util.concurrent.*;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 23:34
 * 线程池使用测试
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建服务
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 执行线程方法
        Future<String> future = service.submit(new ThreadDemo());

        System.out.println(future.get());

        // 关闭连接
        service.shutdown();
    }
}

class ThreadDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("调用线程方法");
        return "调用成功";
    }
}
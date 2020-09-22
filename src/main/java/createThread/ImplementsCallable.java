package createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 13:45
 * 创建线程的第三种方法  implements callable接口
 */
public class ImplementsCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("执行线程run方法");
        return true;
    }

    public static void main(String[] args) throws Exception{
        ImplementsCallable callable = new ImplementsCallable();

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(1);

        //提交执行
        Future<Boolean> result = service.submit(callable);

        boolean isTrue = result.get();
        //关闭连接
        service.shutdownNow();

        System.out.println(isTrue);
    }
}
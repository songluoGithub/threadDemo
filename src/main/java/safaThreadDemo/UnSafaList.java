package safaThreadDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 17:36
 * 不安全的ArraysList
 */
public class UnSafaList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //synchronized (list){
                    list.add(Thread.currentThread().getName());
                //}

            }).start();
        }
        Thread.sleep(100);
        System.out.println(list.size());
    }
}

package threadFunction;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 13:28
 * 线程休眠   适用于倒计时，放大缺陷等场景
 */
public class SleepFunction {
    public static void main(String[] args) throws Exception{
        // timeDown();
        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime = new Date(System.currentTimeMillis());
        }
    }

    // 倒计时
    public static void timeDown() throws Exception{
        int num = 10;
        while (true){
            System.out.println(num);
            Thread.sleep(1000);
            num = num -1;
            if (num <= 0){
                break;
            }
        }
    }
}

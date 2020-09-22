package staticProxy;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 14:43
 * 静态代理实现
 */
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        new Thread(()->{
            System.out.println("我爱你");
        }).start();
        new WeddingCompany(you).HappyMarry();
    }
}


// 结婚
interface Marry{
    void HappyMarry();
}

// 你结婚
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我要去结婚");
    }
}

// 婚庆公司
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry marry){
        this.target = marry;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    public void before(){
        System.out.println("结婚之前筹钱");
    }

    public void after(){
        System.out.println("结婚之后整理");
    }
}

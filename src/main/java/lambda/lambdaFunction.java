package lambda;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 15:06
 * 推导lambda表达式
 * 1.接口实现首先是接口实现
 * 2.静态内部类
 * 3.局部内部类
 * 4.匿名内部类
 * 5.lambda表达式
 */
public class lambdaFunction {
    public static class Love2 implements Ilove{

        @Override
        public void love(int a) {
            System.out.println("I love you2 ==>"+a);
        }
    }

    public static void main(String[] args) {
        Ilove ilove = null;
        // 接口实现
//        ilove = new Love1();
//        ilove.love(1);

        // 静态内部类
//        ilove = new Love2();
//        ilove.love(2);

        class Love3 implements Ilove{

            @Override
            public void love(int a) {
                System.out.println("I love you3 ==>"+a);
            }
        }
        // 局部内部类
//        ilove = new Love3();
//        ilove.love(3);

        //匿名内部类
//        ilove = new Ilove() {
//            @Override
//            public void love(int a) {
//                System.out.println("I love you4 ==>"+a);
//            }
//        };
//        ilove.love(4);
        ilove = (int a) -> System.out.println("I love you5 ==>"+a);
        ilove.love(5);
    }
}

// 函数式接口
interface Ilove{
    void love(int a);
}

// 实现类
class Love1 implements Ilove{

    @Override
    public void love(int a) {
        System.out.println("I love you1 ==>"+a);
    }
}



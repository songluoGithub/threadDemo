package safaThreadDemo;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/22 16:48
 * 同一个账号被两个人取钱
 */
public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        Drawing you = new Drawing(account,50,"你");

        Drawing wifi = new Drawing(account,100,"妻子");

        you.start();
        wifi.start();
    }
}

class Account{
    public int money;// 金钱
    public String name;// 账户

    public Account(int money,String name){
        this.money = money;
        this.name = name;
    }
}

// 银行取款
class Drawing extends Thread{
    // 账户
    public Account account;

    // 取多少钱
    private int drawingMoney;

    // 现在手里多少钱
    private int nowMoney;

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
       synchronized (account){
           // 判断有没有钱
           if (account.money - drawingMoney <0){
               System.out.println(Thread.currentThread().getName()+"余额已经不足！！！");
               return;
           }

           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           //卡内余额 = 卡内余额 - 取的金额
           account.money = account.money - drawingMoney;

           // 现在的钱 = 现在的钱 + 取的金额
           nowMoney = nowMoney + drawingMoney;

           System.out.println(account.name+"卡内余额为："+account.money);
           System.out.println(Thread.currentThread().getName()+"现在手里的余额为："+nowMoney);
       }
    }
}
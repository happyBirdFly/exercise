package Thread;

/**
 * Created by liufeng18899 on 2017/6/17.
 */

/**
 * 线程交替执行
 */
public class WaitNotify {
    public static void main(String args[]){
        String a = "liufeng";//以该对象为共享资源
        new Thread(new NumberPrint((1),a),"1").start();
        new Thread(new NumberPrint((2),a),"2").start();
    }
}
class NumberPrint implements Runnable{
    private int number;
    public String res;
    public static int count = 5;
    public NumberPrint(int number, String a){
        this.number = number;
        res = a;
    }
    public void run(){
        synchronized (res){
            while(count-- > 0){
                try {
                    res.notify();//唤醒等待res资源的线程，把锁交给线程,但是cpu控制权还没有提交（该同步锁执行完毕自动释放锁）
                    System.out.println(" "+number);
                    res.wait();//释放CPU控制权，释放res的锁，本线程阻塞，等待被唤醒。
                    System.out.println("------线程"+Thread.currentThread().getName()+"获得锁，wait()后的代码继续运行："+number);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }//end of while
            return;
        }//synchronized

    }
}
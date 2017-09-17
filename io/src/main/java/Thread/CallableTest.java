package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by liufeng18899 on 2017/6/18.
 */
public class CallableTest {
    public static void main(String[] args){
        Callable ca = new lf();  //创建实现callable接口的对象
        //对象传给FutureTask，FutureTask是一个包装器，它通过接受Callable来创建，它同时实现了
        //Future和Runnable接口
        FutureTask futureTask = new FutureTask(ca);
        //由FutureTask创建一个Thread对象：
        Thread oneThread = new Thread(futureTask);
        oneThread.start();
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+""+i);
        }
    }
}
class lf implements Callable{
    public Object call() throws Exception {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+""+i);
        }
        return null;
    }
}
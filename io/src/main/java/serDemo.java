import springabout.Person;

import java.io.*;

/**
 * Created by liufeng18899 on 2017/6/16.
 * 序列化和反序列化
 */
public class serDemo {
    public static void main(String[] args) throws Exception {
        ser();  //序列化 把对象序列化二进制数据流保存在文件中
        dser(); //反序列话  从文件中读取保存在文件中的对象
    }

    public static void ser() throws Exception {
        File f1 = new File("H:"+File.separator+"hello.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f1));
        out.writeObject(new Person("rollen", 20));   //向文件中写内容
        out.close();
    }

    public static void dser() throws Exception {
        File f2 = new File("H:"+File.separator+"hello.txt");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(f2));
        Object obj = input.readObject();   //读输入文件
        input.close();
        System.out.println(obj);

    }
}
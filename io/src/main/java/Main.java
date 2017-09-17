import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by liufeng18899 on 2017/6/15.
 * 一个压缩单个文件demo
 */
public class Main {
    public static void main(String args[]) throws Exception{
        File f1 = new File("H:"+ File.separator+"hello.txt");
        File zipf1 = new File("H:"+ File.separator+"hello.zip");

        //构建输入流
        InputStream inputStream = new FileInputStream(f1);
        //输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipf1));
        zipOutputStream.putNextEntry(new ZipEntry(f1.getName()));

        //设置注释
        zipOutputStream.setComment("lflf");

        int temp = 0;
        while ((temp=inputStream.read())!=-1){
            zipOutputStream.write(temp);
        }

        //关闭流
        inputStream.close();
        zipOutputStream.close();

    }
}

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by liufeng18899 on 2017/6/15.
 */
public class ZipMutiDoc {
    public static void main(String[] args) throws Exception{
        File f1 = new File("H:"+File.separator+ "Thread");  //构建文件
        File zipfile = new File("H:"+ File.separator+"ZIPIo.zip");

        InputStream input = null;    //输入流定义
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipfile)); //输出流定义
        //添加注释
        zipOutputStream.setComment("hi");

        if(f1.isDirectory()){
            File[] ff = f1.listFiles();  //文件的数量
            for(int i=0;i<ff.length;i++){
                input = new FileInputStream(ff[i]);
                zipOutputStream.putNextEntry(new ZipEntry(ff[i].getName()));  //压缩后文件
                int temp = 0;
                while ((temp=input.read())!=-1){
                    zipOutputStream.write(temp);   //读数据
                }
                input.close();
            }
        }

        zipOutputStream.close();

        System.out.println("系统默认编码为：" + System.getProperty("file.encoding"));
    }
}

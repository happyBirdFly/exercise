package xmlDemo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liufeng18899 on 2017/6/16.
 */

public class Dom4jTest {

    public static void main(String[] args) throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("H:" + File.separator + "book.xml"));
        Element bookstore = document.getRootElement();  //获取root元素

        Iterator it = bookstore.elementIterator(); //获得迭代器

        while(it.hasNext()){
            System.out.println("=====开始遍历某一本书=====");
            Element book = (Element) it.next();

            List<Attribute> bookAttrs = book.attributes();
            for(Attribute attribute : bookAttrs){
                System.out.println("属性名：" + attribute.getName() + "--属性值："
                        + attribute.getValue());
            }

            Iterator itt = book.elementIterator();
            while(itt.hasNext()){
                Element bookChild = (Element) itt.next();
                System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
            }
            System.out.println("结束打印一本书");
        }


    }
}

package springabout;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liufeng18899 on 2017/6/18.
 */
public class SpringTest {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person)applicationContext.getBean("person");
        person.toString();
    }
}

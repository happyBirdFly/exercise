package springabout;

import java.io.Serializable;

/**
 * Created by liufeng18899 on 2017/6/16.
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "  年龄：" + age;
    }


}
package design_mode.prototype;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by Administrator on 2017/4/6.
 */
public class PrototypeTest {
    @Test
//    可以实现复制
    public void testPrototype() throws CloneNotSupportedException {
        Prototype p = new Prototype();
        p.setName("lisi");
        p.setAge(11);
        Prototype clone = p.clone();
        int age = clone.getAge();
        System.out.println(age);
    }

    @Test
//    clone是浅复制
    public void testPrototype2() throws CloneNotSupportedException {
        Person p = new Person(23, "zhang");
        Person p1 = (Person) p.clone();

        String result = p.getName() == p1.getName()
                ? "clone是浅拷贝的" : "clone是深拷贝的";

        System.out.println(result);
    }

//    验证深复制
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Prototype p = new Prototype();
        p.setAge(11);
        p.setName("lisi");
        Prototype pp = (Prototype)p.deepClone();
        System.out.println(p.getName() == pp.getName());
        System.out.println(p.getName().equals(pp.getName()));

    }
}

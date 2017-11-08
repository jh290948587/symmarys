package design_mode.prototype;

import java.io.*;

/**
 * Created by Administrator on 2017/4/6.
 */
public class Prototype implements Cloneable,Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
//    private SerializableObject obj;
    public Prototype clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    /* 深复制 */
    public Object deepClone() throws IOException, ClassNotFoundException {

        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public SerializableObject getObj() {
//        return obj;
//    }
//
//    public void setObj(SerializableObject obj) {
//        this.obj = obj;
//    }
//
//    class SerializableObject implements Serializable {
//        private static final long serialVersionUID = 1L;
//    }
}

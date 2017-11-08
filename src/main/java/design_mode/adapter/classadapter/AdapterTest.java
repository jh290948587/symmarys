package design_mode.adapter.classadapter;

/**
 * Created by Administrator on 2017/4/6.
 */
public class AdapterTest {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}

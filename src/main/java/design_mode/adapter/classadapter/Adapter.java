package design_mode.adapter.classadapter;

/**
 * Created by Administrator on 2017/4/6.
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}

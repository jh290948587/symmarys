package design_mode.factory.abstract_factory;

/**
 * Created by Administrator on 2017/5/8.
 */
public class FactoryTest {
    public static void main(String[] args) {
        Provider provider = new SmsFactory();
        Sender product = provider.product();
        product.send();
    }
}

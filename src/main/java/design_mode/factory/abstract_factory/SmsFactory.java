package design_mode.factory.abstract_factory;

/**
 * Created by Administrator on 2017/5/8.
 */
public class SmsFactory implements Provider {
    public Sender product() {
        return new SmsSender();
    }
}

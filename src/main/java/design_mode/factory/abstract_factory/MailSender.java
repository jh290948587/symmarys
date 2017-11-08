package design_mode.factory.abstract_factory;

/**
 * Created by Administrator on 2017/5/8.
 */
public class MailSender implements Sender {
    public void send() {
        System.out.println("mail");
    }
}

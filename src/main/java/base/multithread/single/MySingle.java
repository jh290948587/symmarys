package base.multithread.single;

/**
 * Created by Administrator on 2017/4/18.
 */
public class MySingle {
    private MySingle(){}

    private static MySingle ms;

    public static MySingle getSingleInstans(){
        if(ms == null){
            synchronized (MySingle.class){
                if(ms == null){
                    ms = new MySingle();
                }
            }
        }
        return ms;
    }
}

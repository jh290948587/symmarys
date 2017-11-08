package base.sort_arithmetic.big_o;

/**
 * Created by Administrator on 2017/8/17.
 */
public class O_n {
    public static int sum(int n){
        int ret = 0;
        for(int i = 0; i <= n; i++){
            ret += 1;
        }
        return ret;
    }

    public static void reverse(String s){
        int n = s.length();
        for(int i = 0; i< n/2; i++){
            O_1.swapTwoInts(s.charAt(i),s.charAt(n-1-i));

        }
    }
}

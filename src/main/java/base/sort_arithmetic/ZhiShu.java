package base.sort_arithmetic;

/**
 * Created by Administrator on 2017/8/17.
 */
public class ZhiShu {
    public static void main(String[] args) {
        findAllZhiShu(1000);
    }

    /**
     * 求num以内的所有质数
     * @param num
     */
    public static void findAllZhiShu(int num){
        int j;
        boolean flag;
        for(int i = 2; i < num; i++){
            flag=false;
            double sqrt = Math.sqrt(i);
            for(j = 2; j <= sqrt; j++){
                if(i%j==0){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                System.out.print(i+"    ");
            }
        }
    }

    public boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        for(int x = 2; x*x <= n; x++){
            if(n%x == 0){
                return false;
            }
        }
        return true;
    }
}

package base.sort_arithmetic.zhishu;

/**
 * Created by Administrator on 2017/4/21.
 */
public class ZhiShu3 {
    public static void main(String[] args) {
        int j;
        boolean flag;
        for(int i=2;i<1000;i++){
            flag=false;
            double sqrt = Math.sqrt(i);
            for(j=2;j<=sqrt;j++){
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

}

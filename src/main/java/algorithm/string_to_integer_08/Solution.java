package algorithm.string_to_integer_08;

/**
 *  具体有这么几种情况需要考虑：
    1. 前面的空格
    2. 除去前面的空格后，可以以“+、-、0”开头，需要做对应的处理
    3. 除了起始处可以出现前2种情况提到的非数字字符，其他地方一旦出现，则忽略该字符以及其后的字符
    4. 考虑边界，即是否超出Integer.MAX_VALUE，Integer.MIN_VALUE。下面的方案采用long作为临时存储，方便做边界的判断。但是还要考虑是否会超出long的最大值，所以笔者采用length长度做初步判断
 */
public class Solution {

    public static void main(String[] args) {
        int i = simpleAtoi(" -87587678435345");
        System.out.println(i);
    }

    public static int simpleAtoi(String str) {

        // 1. null or empty string
        if (str == null || str.length() == 0) return 0;

        // 2. whitespaces
        str = str.trim();

        // 3. +/- sign
        boolean positive = true;
        int i = 0;
        if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) == '-') {
            positive = false;
            i++;
        }

        // 4. calculate real value
        double tmp = 0;
        for ( ; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';

            if (digit < 0 || digit > 9) break;

            // 5. handle min & max
            if (positive) {
                tmp = 10*tmp + digit;
                if (tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else {
                tmp = 10*tmp - digit;
                if (tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }

        int ret = (int)tmp;
        return ret;
    }

    public static int atoi(String str) {
        char[] charArr=str.toCharArray();
        Long result=0L;
        int startIndex=0;
        boolean flag=true;//正数
        int length=0;
        for(int i=0;i<charArr.length;i++){
            if(startIndex==i){
                if(charArr[i]==' '){
                    startIndex++;
                    continue;
                }
                if(charArr[i]=='+'||charArr[i]=='0'){
                    continue;
                }
                if(charArr[i]=='-'){
                    flag=false;
                    continue;
                }
            }
            if(charArr[i]>='0'&&charArr[i]<='9'){
                result=result*10+charArr[i]-'0';
                length++;
                if(length>10){
                    break;
                }
            }else{
                break;
            }
        }
        if(flag){
            if(result>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }else{
            result=-result;
            if(result<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return result.intValue();
    }



    public static int myAtoi(String str) {
        int result = 0;
        int length = 0;
        boolean flag = true;
        int startIndex = 0;
        char[] strChar = str.toCharArray();

        for(int i = 0; i < strChar.length; i++){
            if(startIndex == i){
                if(strChar[i] == ' '){
                    startIndex ++;
                    continue;
                }
                if(strChar[i] == '+' || strChar[i] == '0'){
                    continue;
                }
                if(strChar[i] == '-' || strChar[i] == '0'){
                    flag = false;
                    continue;
                }

            }

            if(strChar[i] >= '0' && strChar[i] <= '9'){
                result = result * 10 + strChar[i];
            }else{
                break;
            }

            if(flag == true){

            }
        }






        return 0;
    }

}

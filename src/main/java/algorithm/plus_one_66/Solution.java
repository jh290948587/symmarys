package algorithm.plus_one_66;

/**
 * Created by Administrator on 2017/11/3.
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{9, 9, 9, 9});
        for(int x: ints){
            System.out.println(x);
        }
    }


    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
//            如果小于9，直接+1，并且返回
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
//            如果 == 9，就把这个值置0，继续下一个
            digits[i] = 0;
        }
//        如果都为9，则增加一位1，后面都是0
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}

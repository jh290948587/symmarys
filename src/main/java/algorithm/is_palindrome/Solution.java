package algorithm.is_palindrome;

/**
 * Created by Administrator on 2017/11/1.
 */
public class Solution {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(1234321);
        System.out.println(palindrome);
    }

    /**
     * 反转数字，并和原数字对比，是否一致
     */
    public static boolean isPalindrome2(int num){
return true;
    }

    /**
     * 这道验证回文数字的题不能使用额外空间，意味着不能把整数变成字符，然后来验证回文字符串。
     * 而是直接对整数进行操作，我们可以利用取整和取余来获得我们想要的数字，
     * 比如 1221 这个数字，如果 计算 1221 / 1000， 则可得首位1， 如果 1221 % 10， 则可得到末尾1，
     * 进行比较，然后把中间的22取出继续比较。
     * @param num
     * @return
     */
    public static boolean isPalindrome(int num){
        if (num < 0) return false;
        int div = 1;
        while (num / div >= 10) {
            div *= 10;
        }
        while (num > 0) {
            int left = num / div;
            int right = num % 10;
            if (left != right) return false;
            num = (num % div) / 10;
            div /= 100;
        }
        return true;
    }
}

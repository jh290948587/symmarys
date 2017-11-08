package algorithm.count_and_say_38;

/**
 * Created by Administrator on 2017/11/2.
 */
public class Solution {
    public static void main(String[] args) {
        String s = countAndSay(6);
        System.out.println(s);
    }


    public static String countAndSay(int n){
        if(n <= 0){
            return "";
        }

        String res = "1";
//        这里n只是判断要走几次，用户传入参数
        while (--n > 0){
            String cur = "";
//            遍历字符串中每一个字符
            for (int i = 0; i < res.length(); ++i) {
//                初始计数cnt为1
                int cnt = 1;
//                当前字符如果有下一个，并且两个字符相等
                while (i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)) {
                    ++cnt;
//                    这里的i加到最后是最后一个重复的字符的索引，for外层的++i是下一个不重复的索引
//                    比如111221，这里的++i值加到2的索引，外层的是加到3的索引
                    ++i;
                }
                cur += String.valueOf(cnt) + res.charAt(i);
            }
            res = cur;
        }
        return res;
    }
}
